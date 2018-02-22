package enums.caffee.logger;

@FunctionalInterface
interface LogTarget { void save(String ... lines); }
