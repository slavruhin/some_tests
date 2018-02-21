package enums.caffee;

import java.time.ZonedDateTime;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class CashdeskLogger {
	
	
	private String CurrentDate() { 
		final DateTimeFormatter formatterDatetime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return formatterDatetime.format(ZonedDateTime.now());
	}

	
	public void appendPurchase(ArrayList<Coin> incoming, Caffee caffee, ArrayList<Coin> returned) {
		String[] line = { String.format("%s [purchase]", CurrentDate() ) };
	}
	
	public void appendPurchase(ArrayList<Coin> incoming, Caffee caffee, String message) {
		
	}

	public void appendAppendContainer(ArrayList<Coin> incoming) {
		
	}

	public void appendClearContainer(ArrayList<Coin> incoming) {
		
	}

	public void appendContainerState(Cashdesk cashdesk) {
		
	}
	
}
