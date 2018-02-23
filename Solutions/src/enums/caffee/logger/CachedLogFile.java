package enums.caffee.logger;

import java.io.FileWriter;
import java.util.ArrayList;

public class CachedLogFile implements LogTarget {
	String filename = "";

	public CachedLogFile(String filename) {
		this.filename = filename; 
	}
	
	LogTarget logger = null;
	void setFileLogger(LogTarget logger) {
		this.logger = logger;
		this.logger.open(filename);
	}
	
	private int limit = 192; 
	public void setBufferLimit(int limit) {
		this.limit = limit;
	}
	
	private ArrayList<String> buffer = new ArrayList<String>();
	public final ArrayList<String> getBuffer() {
		return buffer;
	}

	@Override
	public boolean open(String filename) {
		return logger != null ? logger.open(filename) : false;
	}

	@Override
	public void save(String... lines) {
		for(String s : lines)
			buffer.add(s);
		if(buffer.size() > limit) {
			if(logger != null)
				logger.save(buffer.toArray(new String[buffer.size()]));
			buffer.clear();
		}
	}

	@Override
	public void close() {
		if(logger != null) {
			if(buffer.size() > 0)
				logger.save(buffer.toArray(new String[buffer.size()]));
			logger.close();
		}
	}
}
