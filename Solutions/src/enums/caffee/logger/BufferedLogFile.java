package enums.caffee.logger;

import java.io.*;

public class BufferedLogFile implements LogTarget {
	private String filename = "";

	public BufferedLogFile(String filename) {
			this.filename = filename;
	}

	@Override
	public void save(String... lines) {

		try( FileOutputStream fos = new FileOutputStream(new File(filename)) ) {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for(String s : lines) {
				bw.write(s);
				//bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) 
		{
			System.out.println("Fehler beim Öffnen/Schreiben/Schliessen");
		}
	}
}
