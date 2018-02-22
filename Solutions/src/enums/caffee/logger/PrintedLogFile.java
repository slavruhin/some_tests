package enums.caffee.logger;

import java.io.*;

public class PrintedLogFile implements LogTarget {
	private String filename = "";

	public PrintedLogFile(String filename) {
			this.filename = filename;
	}

	@Override
	public void save(String... lines) {
		PrintWriter f = null;
		try {
			f = new PrintWriter(new FileWriter(filename, true));
			for(String s : lines)
				f.write(s);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(f != null)
				f.close();
		}
	}
}
