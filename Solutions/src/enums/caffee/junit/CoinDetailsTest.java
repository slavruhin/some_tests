/**
 * 
 */
package enums.caffee.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import enums.caffee.Coin;
import enums.caffee.algorithms.*;

/**
 * @author slavruhin-ronn
 *
 */
class CoinDetailsTest {

	/**
	 * Test method for {@link enums.caffee.algorithms.CoinDetails#change(enums.caffee.Coin)}.
	 */
	@Test
	void testChange() {
		
		CoinDetails details = new CoinDetails();
		ArrayList<ArrayList<Coin>> sequence = details.change(Coin.FIFTY_CENTS);
		
		for(ArrayList<Coin> c : sequence)
			System.out.println(c);
		//fail("Not yet implemented");
	}

}
