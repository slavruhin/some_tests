package enums.caffee.algorithms.base.unittest;

import java.util.*;
import org.junit.jupiter.api.Test;

import enums.caffee.Coin;
import enums.caffee.algorithms.base.*;
import enums.caffee.logger.*;

class GenerateChangeCollectionTest {

	/**
	 * test for GenerateChangeCollection
	 */
	@Test
	void testSingleCoin() {
		String filename = "GenerateChangeCollection.log";
		CashdeskLogger logger = new CashdeskLogger();
		logger.setTarget(new LogFile(filename));
		CoinCounter filter = new CoinCounter(10);

		GenerateChangeCollection factory = new GenerateChangeCollection(Coin.TWO_EUROS, filter);
		TreeSet<CoinCounter> collection = (TreeSet<CoinCounter>) factory.getCollection();
		Collection<String> msg = new ArrayList<String>();
		for(CoinCounter coins : collection)
			msg.add(CashdeskLogger.toString(coins.toCollection()));

		logger.append("change TWO EUROS", msg.toArray(new String[msg.size()]));
	}

	/**
	 * test for GenerateChangeCollection
	 */
	@Test
	void testCoinsSequence() {
		String filename = "GenerateChangeCollection.log";
		CashdeskLogger logger = new CashdeskLogger();
		logger.setTarget(new LogFile(filename));
		List<Coin> in = new ArrayList<Coin>(Arrays.asList(new Coin[] { Coin.TWENTY_CENTS, Coin.TEN_CENTS, Coin.TWO_CENTS }));
		CoinCounter filter = new CoinCounter(10);

		GenerateChangeCollection factory = new GenerateChangeCollection(in, filter);
		TreeSet<CoinCounter> collection = (TreeSet<CoinCounter>) factory.getCollection();
		Collection<String> msg = new ArrayList<String>();
		for(CoinCounter coins : collection)
			msg.add(CashdeskLogger.toString(coins.toCollection()));

		logger.append("change array with Coin.TWENTY_CENTS, Coin.TEN_CENTS, Coin.TWO_CENTS", msg.toArray(new String[msg.size()]));
	}
}
