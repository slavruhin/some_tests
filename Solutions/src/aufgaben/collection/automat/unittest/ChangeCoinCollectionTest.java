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
		Collection<Coin> coins = changer.generate(sum);
		CoinCounter counter = new CoinCounter(coins);
		System.out.println(counter);
		assertEquals(sum, counter.sum());

		sum = 23488;
		coins = changer.generate(sum);
		counter = new CoinCounter(coins);
		System.out.println(counter);
		assertEquals(0, counter.sum());
	}

	@Test
	void testGenerate() {
		
		
		fail("Not yet implemented");
	}
}
