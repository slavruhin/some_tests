package enums.caffee.logger;

import java.io.*;

public class LogFile implements LogTarget {
	private String filename = "";

	public LogFile(String filename) {
		this.filename = filename;
	}

	@Override
	public void save(String... lines) {

		FileWriter f = null;
		try {
			f = new FileWriter(filename, true);
			for(String s : lines)
				f.write(s);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(f != null)
				try { f.close(); } catch ( IOException e ) { }
		}
	}
}
