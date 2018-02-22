package enums.caffee.logger;

import java.util.*;

import enums.caffee.Caffee;
import enums.caffee.Cashdesk;
import enums.caffee.Coin;

import java.time.*;
import java.time.format.*;



public class CashdeskLogger {
	
	private LogTarget target = null; //new LogBuffer();
	public void setTarget(LogTarget target) {
		this.target = target;
	}
	
	private void add(String ... lines) {
		if(target != null)
			target.save(lines);
	}
	
	private String CurrentDate() { 
		final DateTimeFormatter formatterDatetime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return formatterDatetime.format(ZonedDateTime.now());
	}

	public void appendPurchase(String message) {
		String[] lines = { 
			String.format("%s [message] %n", CurrentDate()), 
			String.format("\t %s %n", message)
		};
		add(lines);
	}	

	public void appendPurchase(ArrayList<Coin> incoming, Caffee caffee, ArrayList<Coin> returned) {
		String[] lines = { 
			String.format("%s [purchase] %n", CurrentDate()), 
			String.format("\t incoming     : %s %n", toString(incoming)),
			String.format("\t purchase     : %s %n", caffee),
			String.format("\t returned     : %s %n", toString(returned))
		};
		add(lines);
	}

	public void appendAppendContainer(ArrayList<Coin> incoming) {
		String[] lines = { 
				String.format("%s [append] %n", CurrentDate()), 
				String.format("\t incoming : %s %n", toString(incoming)),
		};
		add(lines);
	}

	public void appendClearContainer(ArrayList<Coin> removed) {
		String[] lines = { 
				String.format("%s [clear] %n", CurrentDate()), 
				String.format("\t removed  : %s %n", toString(removed)),
		};
		add(lines);
	}

	public void appendContainerState(Cashdesk cashdesk) {
		String[] lines = { 
				String.format("%s [status]%n", CurrentDate()), 
				toString(cashdesk)
		};
		add(lines);
	}
	
	public static String toString(Cashdesk cashdesk) {
		
		StringBuffer sbuf = new StringBuffer(256);
		for(Map.Entry<Coin, Integer> entry : cashdesk.getContainerCopy().entrySet())
			sbuf.append(String.format("\t%-7s : %d piece(s)%n", entry.getKey(), entry.getValue()));
		sbuf.append(String.format("\tTotal %.2f \u20AC %n", cashdesk.revenue()));
		return sbuf.toString();
	}

	public static String toString(ArrayList<Coin> coins) {
		StringBuffer sbuf = new StringBuffer(256);
		for(Coin c : coins)
			sbuf.append(String.format("%.2f  ", c.value));
		return String.format("%.2f \u20AC -> %d coins (%s)", Cashdesk.sum(coins), coins.size(), sbuf.toString().trim());
	}
}
