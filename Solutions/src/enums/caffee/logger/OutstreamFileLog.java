package enums.caffee.logger;

import java.io.*;

public class OutstreamFileLog implements LogTarget {
	private String filename = "";

	public OutstreamFileLog(String filename) {
		this.filename = filename;
	}

	@Override
	public void save(String... lines) {
		FileOutputStream f = null;
		OutputStreamWriter out = null;
		try {
			f = new FileOutputStream(new File(filename));
			out = new OutputStreamWriter(f);
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
			catch (IOException e) {}
		}
	}
}
