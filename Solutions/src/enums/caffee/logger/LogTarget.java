package enums.caffee.logger;

public interface LogTarget { 
	boolean open(String filename);
	void save(String ... lines);
	void close();
}
