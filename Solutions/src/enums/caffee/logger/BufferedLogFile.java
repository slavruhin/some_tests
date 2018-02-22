package enums.caffee.logger;

import java.io.*;

public class BufferedLogFile implements LogTarget {
	private String filename = "";

	public BufferedLogFile(String filename) {
		this.filename = filename;
	}

	@Override
	public void save(String... lines) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filename), true)));
			for(String s : lines)
				out.write(s);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try { 
				if(out != null) 
					out.close();
			} 
			catch ( IOException e ) {}
		}
	}
}
