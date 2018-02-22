package enums.caffee.logger;

import java.io.*;

public class LogFile implements LogTarget {
	//private String filename = "";
	
	FileWriter out = null;

	public LogFile(String filename) {
		//this.filename = filename;
		try {
			out = new FileWriter(filename, true);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void save(String... lines) {
		try {
			if(out != null)
				for(String s : lines)
					out.write(s);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			try { 
				if(out != null) 
					out.close(); 
			} 
			catch ( IOException ex) {}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			try { 
				if(out != null) 
					out.close(); 
			} 
			catch ( IOException ex ) {}
		}
	}
}
