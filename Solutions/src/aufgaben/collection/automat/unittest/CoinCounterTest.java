package aufgaben.collection.automat.unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import aufgaben.collection.automat.base.*;

class CoinCounterTest {

	@Test
	void testCompareTo() {
		final ArrayList<Coin> c0 = new ArrayList<>();
		final ArrayList<Coin> c1 = new ArrayList<>();

		c0.add(Coin.TWO_EUROS);
		c1.add(Coin.TWO_EUROS);
		c1.add(Coin.TWO_EUROS);

		assertEquals(   0, new CoinCounter(c0).compareTo(new CoinCounter(c0)));
		assertEquals(-200, new CoinCounter(c0).compareTo(new CoinCounter(c1)));
		assertEquals( 200, new CoinCounter(c1).compareTo(new CoinCounter(c0)));

		c0.add(Coin.TWO_EUROS);
		c0.add(Coin.ONE_EURO);
		assertEquals( 100, new CoinCounter(c0).compareTo(new CoinCounter(c1)));
		assertEquals(-100, new CoinCounter(c1).compareTo(new CoinCounter(c0)));

		c1.add(Coin.ONE_EURO);
		c0.add(Coin.FIFTY_CENTS);
		assertEquals( 50, new CoinCounter(c0).compareTo(new CoinCounter(c1)));
		assertEquals(-50, new CoinCounter(c1).compareTo(new CoinCounter(c0)));
	}

	@Test
	void testCoinCounterCoinCounter() {
		CoinCounter c0 = new CoinCounter();
		assertEquals(0, new CoinCounter().sum());
		assertEquals(0, new CoinCounter().count());
		assertEquals(0,  c0.toCollection().size());

		Map<Coin, Integer> mapping = c0.toMap();
		assertEquals(0,  mapping.get(Coin.TWO_EUROS   ).intValue());
		assertEquals(0,  mapping.get(Coin.ONE_EURO    ).intValue());
		assertEquals(0,  mapping.get(Coin.FIFTY_CENTS ).intValue());
		assertEquals(0,  mapping.get(Coin.TWENTY_CENTS).intValue());
		assertEquals(0,  mapping.get(Coin.TEN_CENTS   ).intValue());
		assertEquals(0,  mapping.get(Coin.FIVE_CENTS  ).intValue());
		assertEquals(0,  mapping.get(Coin.TWO_CENTS   ).intValue());
		assertEquals(0,  mapping.get(Coin.ONE_CENT    ).intValue());
	}

	@Test
	void testCoinCounterCollectionOfCoin() {
		Collection<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.TWO_EUROS);

		CoinCounter c0 = new CoinCounter(coins);
		assertEquals(200, c0.sum());

		coins.add(Coin.ONE_EURO);
		c0 = new CoinCounter(coins);
		assertEquals(300, c0.sum());

		coins.add(Coin.ONE_EURO);
		c0 = new CoinCounter(coins);
		assertEquals(400, c0.sum());
	}

	@Test
	void testCoinCounterMapOfCoinInteger() {
		Map<Coin, Integer> mapping = new TreeMap<Coin, Integer>();
		mapping.put(Coin.TWO_EUROS,    new Integer(1));
		mapping.put(Coin.ONE_EURO,     new Integer(2));
		mapping.put(Coin.FIFTY_CENTS,  new Integer(3));
		mapping.put(Coin.TWENTY_CENTS, new Integer(4));
		mapping.put(Coin.TEN_CENTS,    new Integer(5));
		mapping.put(Coin.FIVE_CENTS,   new Integer(6));
		mapping.put(Coin.TWO_CENTS,    new Integer(7));
		mapping.put(Coin.ONE_CENT,     new Integer(8));

		CoinCounter c0 = new CoinCounter(mapping);
		mapping = c0.toMap();
		assertEquals(1,  mapping.get(Coin.TWO_EUROS   ).intValue());
		assertEquals(2,  mapping.get(Coin.ONE_EURO    ).intValue());
		assertEquals(3,  mapping.get(Coin.FIFTY_CENTS ).intValue());
		assertEquals(4,  mapping.get(Coin.TWENTY_CENTS).intValue());
		assertEquals(5,  mapping.get(Coin.TEN_CENTS   ).intValue());
		assertEquals(6,  mapping.get(Coin.FIVE_CENTS  ).intValue());
		assertEquals(7,  mapping.get(Coin.TWO_CENTS   ).intValue());
		assertEquals(8,  mapping.get(Coin.ONE_CENT    ).intValue());
	}

	@Test
	void testClear() {
		CoinCounter c = new CoinCounter(10);
		assertEquals(4830, c.sum());
		c.clear();
		assertEquals(0, c.sum());
	}

	@Test
	void testSum() {
		assertEquals(0, new CoinCounter().sum());
		assertEquals(4830, new CoinCounter(10).sum());
		assertEquals(48300, new CoinCounter(100).sum());
	}

	@Test
	void testCount() {
		assertEquals(0, new CoinCounter().count());
		assertEquals(80, new CoinCounter(10).count());
		assertEquals(800, new CoinCounter(100).count());
	}

	@Test
	void testIsContains() {
		CoinCounter c0 = new CoinCounter(), c1 = new CoinCounter(10),  c2 = new CoinCounter(10),  c3 = new CoinCounter(11);

		assertTrue (c1.isContains(c2));
		assertTrue (c2.isContains(c1));
		assertTrue (c3.isContains(c1));
		assertFalse(c1.isContains(c3));
		assertTrue (c1.isContains(c0));
		assertFalse(c0.isContains(c1));
	}

	@Test
	void testToMap() {
		Map<Coin, Integer> mapping = new CoinCounter(10).toMap();

		assertEquals(10,  mapping.get(Coin.TWO_EUROS   ).intValue());
		assertEquals(10,  mapping.get(Coin.ONE_EURO    ).intValue());
		assertEquals(10,  mapping.get(Coin.FIFTY_CENTS ).intValue());
		assertEquals(10,  mapping.get(Coin.TWENTY_CENTS).intValue());
		assertEquals(10,  mapping.get(Coin.TEN_CENTS   ).intValue());
		assertEquals(10,  mapping.get(Coin.FIVE_CENTS  ).intValue());
		assertEquals(10,  mapping.get(Coin.TWO_CENTS   ).intValue());
		assertEquals(10,  mapping.get(Coin.ONE_CENT    ).intValue());
	}

	@Test
	void testToCollection() {
		CoinCounter c = new CoinCounter(10);
		Collection<Coin> array = c.toCollection();

		assertEquals(80, c.count());
		assertEquals(c.count(), array.size());
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEqualsObject() {
		CoinCounter c0 = new CoinCounter(), c1 = new CoinCounter(10),  c2 = new CoinCounter(10);

		assertFalse(c0 == c1);
		assertFalse(c1 == c2);
		assertFalse(c0.equals(c2));
		assertTrue (c1.equals(c2));
		assertFalse(c0.equals(new Integer(3)));
	}

	@Test
	void testHashCode() {
		CoinCounter c0 = new CoinCounter(), c1 = new CoinCounter(10), c2 = new CoinCounter(10), c3 = c0;
		int i0 = c0.hashCode(), i1 = c1.hashCode(), i2 = c2.hashCode(), i3 = c3.hashCode();
//		System.out.println("hash of c0 : " + i0);
//		System.out.println("hash of c1 : " + i1);
//		System.out.println("hash of c2 : " + i2);
//		System.out.println("hash of c3 : " + i3);

		assertFalse(c0 == c1);
		assertTrue (c0 == c3);
		assertFalse(c0.equals(c2));
		assertTrue (c1.equals(c2));

		assertTrue (i0 == i3);
		assertFalse(i0 == i1);
		assertFalse(i1 == i2);
	}

	@Test
	void testClone() {
		try 
		{
			CoinCounter x = new CoinCounter();
			CoinCounter y = (CoinCounter)x.clone();

			assertFalse(  x == y);
			assertTrue(  x.equals(y));
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	void testToString() {
		CoinCounter c = new CoinCounter(10);
		String s = c.toString();

		assertTrue( s.contains("2,00 €  :  10 piece(s)"));
		assertTrue( s.contains("1,00 €  :  10 piece(s)"));
		assertTrue( s.contains("0,50 €  :  10 piece(s)"));
		assertTrue( s.contains("0,20 €  :  10 piece(s)"));
		assertTrue( s.contains("0,10 €  :  10 piece(s)"));
		assertTrue( s.contains("0,05 €  :  10 piece(s)"));
		assertTrue( s.contains("0,02 €  :  10 piece(s)"));
		assertTrue( s.contains("0,01 €  :  10 piece(s)"));
	}

	@Test
	void testSubtractCollection() {
		CoinCounter c = new CoinCounter(10);
		assertEquals(4830, c.sum());

		Collection<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.TWO_EUROS);
		coins.add(Coin.FIFTY_CENTS);
		assertTrue(c.subtract(coins));
		assertEquals(4580, c.sum());

		assertTrue(c.subtract(new CoinCounter(5)));
		assertEquals(2165, c.sum());

		assertFalse(c.subtract(new CoinCounter(6)));
		assertEquals(2165, c.sum());

		assertTrue(c.subtract(new CoinCounter()));
		assertEquals(2165, c.sum());
	}

	@Test
	void testAddCollection() {
		CoinCounter c = new CoinCounter(10);
		assertEquals(4830, c.sum());

		Collection<Coin> coins = new ArrayList<Coin>();
		coins.add(Coin.TWO_EUROS);
		coins.add(Coin.FIFTY_CENTS);
		c.add(coins);
		assertEquals(5080, c.sum());

		c.add(new CoinCounter(5));
		assertEquals(7495, c.sum());

		c.add(new CoinCounter(6));
		assertEquals(10393, c.sum());

		c.add(new CoinCounter());
		assertEquals(10393, c.sum());
	}

	@Test
	void testCoinsToString() {
		String s = "";
		for(Coin c : Coin.values())
			s += c.toString() + " ";
		assertEquals(s, "2,00 € 1,00 € 0,50 € 0,20 € 0,10 € 0,05 € 0,02 € 0,01 € ");
	}
}
