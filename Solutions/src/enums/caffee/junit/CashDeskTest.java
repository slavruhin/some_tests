package enums.caffee.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import enums.caffee.*;

class CashDeskTest {

	@Test
	void testPay() {
		CashDesk cashdesk = initCashDesc(10);
		System.out.println(cashdesk);
		System.out.println();
		
		ArrayList<Coin> coins = initCoinsArray(2);
		for(int i = 0 ; i < 20 ; ++i) {
			
			ArrayList<Coin> ret = cashdesk.purchase(coins, Caffee.CAPPUCCINO);
			System.out.println(String.format("%2d : Try to pay : %s", i, Caffee.CAPPUCCINO));
			System.out.println(String.format("incoming : %.2f", CashDesk.summe(coins)));
			System.out.println(String.format("returned : %.2f", CashDesk.summe(ret)));
			System.out.print("\t");
			for(Coin c : ret)
				System.out.print(c + " | ");
			System.out.println();
			System.out.println(cashdesk);
			System.out.println();
		}

	}

	@Test
	void testSumme() {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.ONE_CENT);
		assertEquals(.01, CashDesk.summe(coins));
		coins.add(Coin.TWO_CENTS);
		assertEquals(.03, CashDesk.summe(coins));
		coins.add(Coin.FIVE_CENTS);
		assertEquals(.08, CashDesk.summe(coins));
		coins.add(Coin.TEN_CENTS);
		assertEquals(.18, CashDesk.summe(coins));
		coins.add(Coin.TWENTY_CENTS);
		assertEquals(.38, CashDesk.summe(coins));
		coins.add(Coin.FIFTY_CENTS);
		assertEquals(.88, CashDesk.summe(coins));
		coins.add(Coin.ONE_EURO);
		assertEquals(1.88, CashDesk.summe(coins));
		coins.add(Coin.TWO_EUROS);
		assertEquals(3.88, CashDesk.summe(coins));
		
		System.out.println("Total summe of incomint coins : " + CashDesk.summe(coins) + " \u20AC");
		System.out.println();
	}

	@Test
	void testChange() {
		CashDesk cashdesk = initCashDesc(0);
		double value = .68;
		ArrayList<Coin> coins = cashdesk.change(value);
		assertNotEquals(value, CashDesk.summe(coins));
		System.out.println(String.format("changed %.2f : result %.2f %n", value, CashDesk.summe(coins)));

		cashdesk = initCashDesc(3);
		coins = cashdesk.change(value);
		assertEquals(value, CashDesk.summe(coins));
		System.out.println(String.format("changed %.2f : result %.2f %n", value, CashDesk.summe(coins)));

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
		CashDesk desk = new CashDesk();
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
		String s = new CashDesk().toString();
		assertTrue(s.length() > 0);
		System.out.println(s);
		System.out.println();
	}
	
	static CashDesk initCashDesc(int count) {
		CashDesk desk = new CashDesk();
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

	static ArrayList<Coin> initCoinsArray(int type) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		switch (type) {
			case 1:
				coins.add(Coin.ONE_EURO);
				break;
			case 2:
				coins.add(Coin.TWO_EUROS);
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
