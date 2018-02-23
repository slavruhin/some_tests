package enums.caffee.logger;

import java.io.*;

public class PrintedLogFile implements LogTarget {
	String filename = "";
	boolean append = true;
	PrintWriter out = null;

	public PrintedLogFile(String filename) {
		open(filename); 
	}

	@Override
	public boolean open(String filename) {
		try {
			out = new PrintWriter(new FileWriter(filename, true));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return false;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}
		this.filename = filename;
		return true;
	}

	@Override
	public void save(String... lines) {
		try {
			if(out != null || (out == null && open(filename)) ) {
				for(String s : lines)
					out.write(s);
				out.flush();
			}
		} catch (Exception e ) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void close() {
		try {
			if(out != null)
				out.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
