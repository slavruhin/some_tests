package enums.caffee.logger;

import java.util.*;

public class LogBuffer implements LogTarget {
	private ArrayList<String> buffer = new ArrayList<String>();

	@Override
	public void save(String... lines) {
		for(String s : lines)
			buffer.add(s);
	}

	public final ArrayList<String> getBuffer() {
		return buffer;
	}
}
