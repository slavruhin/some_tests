package enums.caffee;

import java.util.*;

public class CashdeskReport {

	public static String toString(Cashdesk cashdesk) {
		
		StringBuffer sbuf = new StringBuffer(256);
		sbuf.append(String.format("Cash desk contains %n"));
		for(Map.Entry<Coin, Integer> entry : cashdesk.getContainerCopy().entrySet())
			sbuf.append(String.format("\t%-7s : %d piece(s)%n", entry.getKey(), entry.getValue()));
		sbuf.append(String.format("Total %.2f \u20AC %n", cashdesk.revenue()));
		return sbuf.toString();
	}

	public static String toString(ArrayList<Coin> coins) {
		StringBuffer sbuf = new StringBuffer(256);
		for(Coin c : coins)
			sbuf.append(String.format("%.2f  ", c.value));
		return String.format("%.2f \u20AC -> %d coins (%s) %n", Cashdesk.sum(coins), coins.size(), sbuf.toString().trim());
	}
}
