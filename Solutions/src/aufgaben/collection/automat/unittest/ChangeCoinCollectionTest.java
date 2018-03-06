package aufgaben.collection.automat.unittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import aufgaben.collection.automat.base.*;

class ChangeCoinCollectionTest {

	@Test
	void testChangeCoinCollection() {
		DefaultChangeCoinCollection changer = new DefaultChangeCoinCollection(new CoinCounter(10));

		int sum = 234;
		Collection<Coin> coins = changer.change(sum);
		CoinCounter counter = new CoinCounter(coins);
		System.out.println(counter);
		assertEquals(sum, counter.sum());

		sum = 23488;
		coins = changer.change(sum);
		counter = new CoinCounter(coins);
		System.out.println(counter);
		assertEquals(0, counter.sum());
	}

	@Test
	void testGenerateDefaultCollection() {
		DefaultChangeCoinCollection changer = new DefaultChangeCoinCollection(new CoinCounter(10));
		Collection<Coin> coins = changer.change(148);
		System.out.println(coins.size());
		String s = "";
		for(Coin c : coins)
			s += c.toString() + " ";
		System.out.println(s);
	}
	
	@Test
	void testChangeMapping() {
		for(Coin coin : Coin.values()) {
			Collection<Coin> changed = MapCoinChanger.get(coin);
			assertNotNull(changed);
			String s = "";
			for(Coin c : changed)
				s += c.toString() + " ";
			System.out.println(s);
		}
	}
	
	

	@Test
	void testGenerateExtendedCollection() {
		ExtendChangeCoinCollection changer = new ExtendChangeCoinCollection(new CoinCounter(10));
		Collection<Coin> coins = changer.change(148);
		System.out.println(coins.size());
		String s = "";
		for(Coin c : coins)
			s += c.toString() + " ";
		System.out.println(s);
		
		Collection<Collection<Coin>> sequences = changer.changeTraverse(coins);
		for(Collection<Coin> seq : sequences) {
			s = "";
			for(Coin c : seq)
				s += c.toString() + " ";
			System.out.println(s);
		}
	}
}
