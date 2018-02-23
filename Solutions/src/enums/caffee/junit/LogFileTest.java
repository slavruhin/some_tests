package enums.caffee.junit;


import java.io.*;
import java.text.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import enums.caffee.logger.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LogFileTest {
	
	private final String[] lines = { 
		"some line", 
		"---------" 
	};

	private String generateLogPrefix() {
	    return new SimpleDateFormat("yyyy_MM_dd").format(new Date());
	}

	private long getFileLength(String filename) {
        File file = new File(filename);
        return file.exists() ? file.length() : -1;
	}

	private void deleteFile(String filename) {
		File f = new File(filename);
		if(f.exists())
			f.delete();
	}

	@Test
	void testLogFile() {
		String filename = generateLogPrefix() + "_logfile_standard.log";
		LogTarget logger = new LogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		logger.close();
		assertEquals(0, getFileLength(filename) % 18000);
		deleteFile(filename);
	}

	@Test
	void testPrintedLogFile() {
		String filename = generateLogPrefix() + "_logfile_printed.log";
		LogTarget logger = new PrintedLogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
		deleteFile(filename);
	}

	@Test
	void testCacchedLogFile() {
		String filename = generateLogPrefix() + "_logfile_cached.log";
		LogTarget logger = new CachedLogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
		deleteFile(filename);
	}
	@Test
	void testBufferedLogFile() {
		String filename = generateLogPrefix() + "_logfile_buffered.log";
		LogTarget logger = new BufferedLogFile(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
		deleteFile(filename);
	}

	@Test
	void testOutstreamLogFile() {
		String filename = generateLogPrefix() + "_logfile_outstream.log";
		LogTarget logger = new OutstreamFileLog(filename);
		for(int i = 0; i < 1000; ++i)
			logger.save(lines);
		assertEquals(0, getFileLength(filename) % 18000);
		deleteFile(filename);
	}
	
}
