package enums.caffee.logger;

@FunctionalInterface
public interface LogTarget { void save(String ... lines); }
