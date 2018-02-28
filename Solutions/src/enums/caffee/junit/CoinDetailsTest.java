/**
 * 
 */
package enums.caffee.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import enums.caffee.*;
import enums.caffee.algorithms.*;
import enums.caffee.logger.*;

/**
 * @author S.Lavruhin-Ronn
 *
 */
class CoinDetailsTest {

	/**
	 * Test method for {@link enums.caffee.algorithms.CoinChangeDetails#change(enums.caffee.Coin)}.
	 */
	@Test
	void testChangeInPosition() {
		
		CoinChangeDetails details = new CoinChangeDetails();
		ArrayList<Coin> sequence = new ArrayList<Coin>();
		sequence.add(Coin.ONE_CENT);
		sequence.add(Coin.TWO_EUROS);
		
		boolean b = details.changeInPosition(sequence, 0);
		assertEquals(false, b);
		System.out.println(CashdeskLogger.toString(sequence));

		b = details.changeInPosition(sequence, 1);
		assertEquals(true, b);
		System.out.println(CashdeskLogger.toString(sequence));
	}

	/**
	 * Test method for {@link enums.caffee.algorithms.CoinChangeDetails#change(enums.caffee.Coin)}.
	 */
	@Test
	void testChangeCurrentTraverse() {
		
		CoinChangeDetails details = new CoinChangeDetails();
		ArrayList<Coin> sequence = new ArrayList<Coin>();
		sequence.add(Coin.TWO_EUROS);
		sequence.add(Coin.TWO_EUROS);
		System.out.println(CashdeskLogger.toString(sequence));
		
		ArrayList<ArrayList<Coin>> result = details.changeCurrentTraverse(sequence);
		for(ArrayList<Coin> seq : result)
			System.out.println(CashdeskLogger.toString(seq));
	}

	/**
	 * Test method for {@link enums.caffee.algorithms.CoinChangeDetails#change(enums.caffee.Coin)}.
	 */
	@Test
	void testChangeCurrentTraverseLimitted() {
		
		CoinChangeDetails details = new CoinChangeDetails();
		ArrayList<Coin> sequence = new ArrayList<Coin>();
		sequence.add(Coin.TWO_EUROS);
		sequence.add(Coin.TWO_EUROS);
		System.out.println(CashdeskLogger.toString(sequence));
		
		ArrayList<ArrayList<Coin>> result = details.changeLimitted(sequence, 20);
		for(ArrayList<Coin> seq : result)
			System.out.println(CashdeskLogger.toString(seq));
	}
}
