package enums.caffee.logger;

import java.util.*;

public class LogBuffer implements LogTarget {
	private ArrayList<String> buffer = new ArrayList<String>();


	public final ArrayList<String> getBuffer() {
		return buffer;
	}

	@Override
	public boolean open(String filename) {
		return true;
	}

	@Override
	public void save(String... lines) {
		for(String s : lines)
			buffer.add(s);
	}

	@Override
	public void close() {
	}
}
