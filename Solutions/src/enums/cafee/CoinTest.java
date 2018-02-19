package enums.cafee;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import org.junit.jupiter.api.Test;

class CoinTest {

//	@Test
//	void test() {
//		for(Coin c : Coin.values())
//			System.out.println(c);
//		System.out.println();
//
//		for(Caffee c : Caffee.values())
//			System.out.println(c);
//		System.out.println();
//	}
//	
//	@Test
//	void testCashDesk() {
//		Comparator<Double> comparator = (x,y) -> (int)Math.round((x -y)*100); 
//		
//		CashDesk cash = new CashDesk();
//		cash.add(Coin.ONE_CENT, 10);
//		assertEquals(0, comparator.compare(  .10, cash.revenue()));
//		cash.add(Coin.TWO_CENTS, 10);
//		assertEquals(0, comparator.compare(  .30, cash.revenue()));
//		cash.add(Coin.FIVE_CENTS, 10);
//		assertEquals(0, comparator.compare(  .80, cash.revenue()));
//		cash.add(Coin.TEN_CENTS, 10);
//		assertEquals(0, comparator.compare( 1.80, cash.revenue()));
//		cash.add(Coin.TWENTY_CENTS, 10);
//		assertEquals(0, comparator.compare( 3.80, cash.revenue()));
//		cash.add(Coin.FIFTY_CENTS, 10);
//		assertEquals(0, comparator.compare( 8.80, cash.revenue()));
//		cash.add(Coin.ONE_EURO, 10);
//		assertEquals(0, comparator.compare(18.80, cash.revenue()));
//		cash.add(Coin.TWO_EUROS, 10);
//		assertEquals(0, comparator.compare(38.80, cash.revenue()));
//		System.out.println(cash);
//		System.out.println();
//	}
//	
//	@Test
//	void testCashDeskCalculateChange() {
//		
//		for(Caffee c : Caffee.values())
//			System.out.println(c);
//		System.out.println();
//
//		ArrayList<Coin> incoming = new ArrayList<Coin>();
//		incoming.add(Coin.ONE_EURO);
//
//		System.out.println("incoming " + incoming.get(0));
//		System.out.println();
//		
//		Caffee caffee = Caffee.CAPPUCCINO;
//		System.out.printf("change if pay (%s) : %.2f \u20AC %n", caffee, CashProcessor.getDifference(incoming, caffee));
//		System.out.println();
//	}
//	
//	@Test
//	void testCashProcessor() {
//		CashProcessor cp = initializeCashProcessor();
//		Coin[] coins = new Coin[] { Coin.TWO_CENTS, Coin.TWO_CENTS, Coin.FIVE_CENTS, Coin.ONE_EURO, Coin.FIVE_CENTS };
//		cp.pay(new ArrayList<Coin>(Arrays.asList(coins)), Caffee.ESPRESSO);
//	}
//	
//	static CashProcessor initializeCashProcessor() {
//		CashProcessor cp = new CashProcessor();
//		// initialize cash desk:
//		cp.add(Coin.ONE_CENT,     10);
//		cp.add(Coin.TWO_CENTS,    10);
//		cp.add(Coin.FIVE_CENTS,   10);
//		cp.add(Coin.TEN_CENTS,    10);
//		cp.add(Coin.TWENTY_CENTS, 10);
//		cp.add(Coin.FIFTY_CENTS,  10);
//		cp.add(Coin.ONE_EURO,     10);
//		cp.add(Coin.TWO_EUROS,    10);
//		return cp;
//	}

	
	@Test
	void testSortedCashDesk() {
		printUsingElements();

		CashProcessor cash = new CashProcessor();
			cash.add(Coin.TWO_EUROS,    10);
			cash.add(Coin.ONE_EURO,     10);
			cash.add(Coin.FIFTY_CENTS,  10);
			cash.add(Coin.TWENTY_CENTS, 10);
			cash.add(Coin.TEN_CENTS,    10);
			cash.add(Coin.FIVE_CENTS,   10);
			cash.add(Coin.TWO_CENTS,    10);
			cash.add(Coin.ONE_CENT,     10);
		System.out.println(cash);
		System.out.println();

		ArrayList<Coin> coins = cash.getPayback(.54);
		System.out.println(toString(coins));
		System.out.println();

		System.out.println(cash);
		System.out.println();
	}
	
	void printUsingElements() {
		for(Coin c : Coin.values())
			System.out.println(c);
		System.out.println();

		for(Caffee c : Caffee.values())
			System.out.println(c);
		System.out.println();
	}

	public String toString(ArrayList<Coin> coins) {
		StringBuffer sbuf = new StringBuffer(256);
		sbuf.append(String.format("Cash desk contains %n"));
		sbuf.append(String.format("----------------------%n"));
		for(Coin c : coins)
			sbuf.append(String.format("%s %n", c));
		sbuf.append(String.format("----------------------%n"));
		sbuf.append(String.format("Revenue %.2f \u20AC %n", CashProcessor.summe(coins)));
		return sbuf.toString();
	}
}
