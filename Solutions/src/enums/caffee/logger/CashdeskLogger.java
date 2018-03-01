package enums.caffee.logger;

import java.util.*;

import enums.caffee.Caffee;
import enums.caffee.Cashdesk;
import enums.caffee.Coin;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;

public class CashdeskLogger {
	
	public static String generateFilenamePrefix() {
	    return new SimpleDateFormat("yyyy_MM_dd_").format(new Date());
	}
	
	public static String generateFilename(String logdir, String filename) {
		// todo : create directory
		if(!logdir.isEmpty())
			logdir += "/";
	    return logdir + generateFilenamePrefix() + filename;
	}
	

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

	public void append(String head, String ... messages) {
		String[] lines = new String[messages.length + 1];
		lines[0] = String.format("%s [%s] %n", CurrentDate(), head);
		for(int i = 0 ; i < messages.length ; ++i)
			lines[i + 1] = String.format("\t %s %n", messages[i]);
		add(lines);
	}

	public void append(String message) {
		String[] lines = { 
			String.format("%s [message] %n", CurrentDate()), 
			String.format("\t %s %n", message)
		};
		add(lines);
	}	

	public void appendPurchase(Collection<Coin> incoming, Caffee caffee, Collection<Coin> returned) {
		String[] lines = { 
			String.format("%s [purchase] %n", CurrentDate()), 
			String.format("\t incoming     : %s %n", toString(incoming)),
			String.format("\t purchase     : %s %n", caffee),
			String.format("\t returned     : %s %n", toString(returned))
		};
		add(lines);
	}

	public void appendAppendContainer(Collection<Coin> incoming) {
		String[] lines = { 
				String.format("%s [append] %n", CurrentDate()), 
				String.format("\t incoming : %s %n", toString(incoming)),
		};
		add(lines);
	}

	public void appendClearContainer(Collection<Coin> removed) {
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

	public static String toString(Collection<Coin> coins) {
		StringBuffer sbuf = new StringBuffer(256);
		for(Coin c : coins)
			sbuf.append(String.format("%.2f  ", c.value));
		return String.format("%.2f \u20AC -> %3d coins (%s)", Cashdesk.sum(coins), coins.size(), sbuf.toString().trim());
	}
}
