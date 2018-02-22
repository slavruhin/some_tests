package enums.caffee.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import enums.caffee.logger.*;

class LogFileTest {

	@Test
	void testLogFile() {
		LogFile logger = new LogFile("logfile_01.log");
		for(int i = 0; i < 1000; ++i)
			logger.save("some line", "---------");
	}

}
