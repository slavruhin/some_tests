package enums.caffee.algorithms;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import enums.caffee.Coin;

public class DefaultCashChangeAlgorithm implements CashChangable {

	@Override
	public ArrayList<Coin> change(double summe, TreeMap<Coin, Integer> container) {
		ArrayList<Coin> coins = new ArrayList<Coin>();
		for(Map.Entry<Coin, Integer> entry : container.entrySet()) {
			int count = (int)(summe / entry.getKey().value);
			if(count > 0) {
				int number = entry.getValue().intValue();
				count = count < number ? count : number;
				for(int i = 0 ; i < count ; ++i)
					coins.add(entry.getKey());
				summe -= count * entry.getKey().value;
			}
		}
		return coins;
	}
}
