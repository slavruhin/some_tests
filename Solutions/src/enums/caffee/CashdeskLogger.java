package enums.caffee;

import java.util.*;
import java.time.*;
import java.time.format.*;

public class CashdeskLogger {
	
	private ArrayList<String> buffer = new ArrayList<String>();
	private void add(String ... lines) {
		for(String s : lines)
			buffer.add(s);
	}
	
	private String CurrentDate() { 
		final DateTimeFormatter formatterDatetime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return formatterDatetime.format(ZonedDateTime.now());
	}

	
	public void appendPurchase(ArrayList<Coin> incoming, Caffee caffee, ArrayList<Coin> returned) {
		String[] lines = { 
				String.format("%s [purchase]", CurrentDate()), 
				String.format("\t incoming : %s", CashdeskReport.toString(incoming)),
				String.format("\t purchase : %s", caffee),
				String.format("\t returned : %s", CashdeskReport.toString(returned))
		};
		add(lines);
	}

	public void appendAppendContainer(ArrayList<Coin> incoming) {
		String[] lines = { 
				String.format("%s [append]", CurrentDate()), 
				String.format("\t incoming : %s", CashdeskReport.toString(incoming)),
		};
		add(lines);
	}

	public void appendClearContainer(ArrayList<Coin> removed) {
		String[] lines = { 
				String.format("%s [clear]", CurrentDate()), 
				String.format("\t removed   : %s", CashdeskReport.toString(removed)),
		};
		add(lines);
	}

	public void appendContainerState(Cashdesk cashdesk) {
		String[] lines = { 
				String.format("%s [status]", CurrentDate()), 
				CashdeskReport.toString(cashdesk)
		};
		add(lines);
	}
	
}
