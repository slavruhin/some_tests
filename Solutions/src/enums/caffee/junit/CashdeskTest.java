package enums.caffee.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import enums.caffee.*;

class CashdeskTest {

	@Test
	void testPurchase() {
		System.out.println("CashDeskTest.testPurchase()");
		
		for(int x = 1; x < 4 ; ++x) {
			System.out.println();
			System.out.println();
			Cashdesk cashdesk = initCashDesc(10);
			System.out.println(CashdeskReport.toString(cashdesk));
			System.out.println();
			ArrayList<Coin> coins = initCoinsArray(x);
			for(int i = 0 ; i < 20 ; ++i) {
				System.out.println(String.format("Trying %d.%2d [ purchase a %s ]", x, i, Caffee.CAPPUCCINO));
				if(startPurchase(cashdesk, coins,  Caffee.CAPPUCCINO) == false)
					break;
			}
			System.out.println();
			System.out.println(CashdeskReport.toString(cashdesk));
			System.out.println();
		}
	}

	/**
	 * helper function to test purchase
	 * @param cashdesk
	 * @param incoming
	 * @param caffee
	 * @return
	 */
	static boolean startPurchase(Cashdesk cashdesk, ArrayList<Coin> incoming,  Caffee caffee) {

		System.out.println("\tincoming : " + CashdeskReport.toString(incoming));
		ArrayList<Coin> coins = cashdesk.purchase(incoming, caffee);
		if(Cashdesk.sum(coins) == Cashdesk.sum(incoming)) {
			System.out.println("*** Not accepted. Break.");
			System.out.println();
			return false;
		}
		System.out.println("*** Successful");
		System.out.println("\treturned : " + CashdeskReport.toString(coins));
		System.out.println();
		return true;
	}

	
	@Test
	void testSumme() {
		System.out.println("CashDeskTest.testSumme()");
		ArrayList<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.ONE_CENT);
		assertEquals(.01, Cashdesk.sum(coins));
		coins.add(Coin.TWO_CENTS);
		assertEquals(.03, Cashdesk.sum(coins));
		coins.add(Coin.FIVE_CENTS);
		assertEquals(.08, Cashdesk.sum(coins));
		coins.add(Coin.TEN_CENTS);
		assertEquals(.18, Cashdesk.sum(coins));
		coins.add(Coin.TWENTY_CENTS);
		assertEquals(.38, Cashdesk.sum(coins));
		coins.add(Coin.FIFTY_CENTS);
		assertEquals(.88, Cashdesk.sum(coins));
		coins.add(Coin.ONE_EURO);
		assertEquals(1.88, Cashdesk.sum(coins));
		coins.add(Coin.TWO_EUROS);
		assertEquals(3.88, Cashdesk.sum(coins));
		
		System.out.println("Total summe of incomint coins : " + Cashdesk.sum(coins) + " \u20AC");
		System.out.println();
	}

	@Test
	void testChange() {
		System.out.println("CashDeskTest.testChange()");
		Cashdesk cashdesk = initCashDesc(0);
		double value = .68;
		ArrayList<Coin> coins = cashdesk.change(value);
		assertNotEquals(value, Cashdesk.sum(coins));
		System.out.println(String.format("changed %.2f : result %.2f %n", value, Cashdesk.sum(coins)));

		cashdesk = initCashDesc(3);
		coins = cashdesk.change(value);
		assertEquals(value, Cashdesk.sum(coins));
		System.out.println(String.format("changed %.2f : result %.2f %n", value, Cashdesk.sum(coins)));

		for(Coin c : coins)
			System.out.print(c + " | ");
		System.out.println();
	}

	@Test
	void testAddArrayListOfCoin() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCoinInt() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveArrayListOfCoin() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveCoinInt() {
		fail("Not yet implemented");
	}

	@Test
	void testRevenue() {
		System.out.println("CashDeskTest.testRevenue()");
		Cashdesk desk = new Cashdesk();
		desk.add(Coin.FIFTY_CENTS, 20);
		double revenue = desk.revenue();
		assertEquals(10., revenue);
		System.out.println("revenue : " + revenue);
		System.out.println();

		desk.add(Coin.TWENTY_CENTS, 10);
		revenue = desk.revenue();
		assertEquals(12., revenue);
		System.out.println("revenue : " + revenue);
		System.out.println();
	}

	@Test
	void testToString() {
		System.out.println("CashDeskTest.testToString()");
		String s = new Cashdesk().toString();
		assertTrue(s.length() > 0);
		System.out.println(s);
		System.out.println();
	}
	
	static Cashdesk initCashDesc(int count) {
		System.out.println("CashDeskTest.initCashDesc()");
		Cashdesk desk = new Cashdesk();
		desk.add(Coin.ONE_CENT     , count);
		desk.add(Coin.TWO_CENTS    , count);
		desk.add(Coin.FIVE_CENTS   , count);
		desk.add(Coin.TEN_CENTS    , count);
		desk.add(Coin.TWENTY_CENTS , count);
		desk.add(Coin.FIFTY_CENTS  , count);
		desk.add(Coin.ONE_EURO     , count);
		desk.add(Coin.TWO_EUROS    , count);
		return desk;
	}

	/**
	 * Generate a coins sequence in depending of test
	 * @param type
	 * @return
	 */
	static ArrayList<Coin> initCoinsArray(int type) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		switch (type) {
			case 1:
				coins.add(Coin.ONE_EURO);
				break;
			case 2:
				coins.add(Coin.TWO_EUROS);
				break;
			case 3:
				coins.add(Coin.ONE_EURO);
				coins.add(Coin.FIFTY_CENTS);
				break;
			default:
				break;
		}
			//coins.add(Coin.TWO_CENTS);
			//coins.add(Coin.ONE_CENT);
			//coins.add(Coin.ONE_CENT);
			//coins.add(Coin.FIVE_CENTS);
			//coins.add(Coin.TEN_CENTS);
			//coins.add(Coin.TWENTY_CENTS);
			//coins.add(Coin.FIFTY_CENTS);
			//coins.add(Coin.ONE_EURO);
			//coins.add(Coin.TWO_EUROS);
		return coins;
	}
}
