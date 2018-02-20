package enums.caffee;

import java.util.ArrayList;
import java.util.TreeMap;

@FunctionalInterface
public interface CashChangable {
	ArrayList<Coin> change(double summe, TreeMap<Coin, Integer> container);
}
