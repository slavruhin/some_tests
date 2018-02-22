package enums.caffee.junit;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import enums.caffee.logger.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

class LogFileTest {
	
	private final String[] lines = { "some line", "---------" };
	
	@Before 
	public void deleteTestfiles() {
		String[] files = { 
			"logfile_standard.log", 
			"logfile_printed.log", 
			"logfile_outstream.log", 
			"logfile_outstream.log"
		};
		for( String filename : files ) {
			File file = new File(filename);
			if(file.exists())
				file.delete();
		}
	}

	@Test
	void testLogFile() {
		String filename = "logfile_standard.log";
		LogTarget logger = new LogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
	}

	@Test
	void testPrintedLogFile() {
		String filename = "logfile_printed.log";
		LogTarget logger = new PrintedLogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
	}

	@Test
	void testBufferedLogFile() {
		String filename = "logfile_buffered.log";
		LogTarget logger = new BufferedLogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
	}

	@Test
	void testOutstreamLogFile() {
		String filename = "logfile_outstream.log";
		LogTarget logger = new OutstreamFileLog(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
	}
	
	private long getFileLength(String filename) {
        File file = new File(filename);
        return file.exists() ? file.length() : -1;
	}
}
