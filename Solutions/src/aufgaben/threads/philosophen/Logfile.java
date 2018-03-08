package aufgaben.threads.philosophen;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

class Logger {
	
	private StringBuilder sb = new StringBuilder();

	public synchronized void addMessage(String message) {
		sb.append(String.format("%s : %s %n", DateFormat.getInstance().format(new Date()), message));
	}
	
	public synchronized String getLog() {
		return sb.toString();
	}
	
	public synchronized void clear() {
		sb = new StringBuilder();
	}
} 

public class Logfile {
	String filename = "";
	boolean append = true;
	FileWriter out = null;

	public Logfile(String filename) {
		open(filename); 
	}
	
	public boolean open(String filename) {
		try {
			out = new FileWriter(filename, true);
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
	
	public void save(String ... lines) {
		try {
			if(out != null || (out == null && open(filename)) ) {
				for(String s : lines)
					out.write(s);
				out.flush();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (Exception e ) {
			System.err.println(e.getMessage());
		}
	}

	public void close() {
		try {
			if(out != null)
				out.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
