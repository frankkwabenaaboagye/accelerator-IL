package frank.DesignPatterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        // Get the singleton Logger instance and log messages
        Logger logger = Logger.getInstance();

        // Log a generic message
        logger.log("This is a log message.");

        // Log an informational message
        logger.info("This is an info message.");

        // Log an error message
        logger.error("This is an error message.");
    }
}
