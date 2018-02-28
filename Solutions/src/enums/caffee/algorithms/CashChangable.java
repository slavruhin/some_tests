package enums.caffee.algorithms;

import java.util.ArrayList;
import java.util.TreeMap;

import enums.caffee.Coin;

@FunctionalInterface
public interface CashChangable {
	ArrayList<Coin> change(double summe, TreeMap<Coin, Integer> container);
}
