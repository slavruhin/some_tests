package enums.caffee.logger;

import java.io.*;

public class OutstreamFileLog implements LogTarget {
	String filename = "";
	boolean append = true;
	OutputStreamWriter out = null;

	public OutstreamFileLog(String filename) {
		open(filename); 
	}
	
	@Override
	public boolean open(String filename) { //throws FileNotFoundException, IOException  {
		try {
			//FileOutputStream f = new FileOutputStream(new File(filename));
			out = new OutputStreamWriter(new FileOutputStream(new File(filename), append));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			return false;
		} catch (Exception e) {
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
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (Exception e ) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void close() {
		try {
			if(out != null)
				out.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
