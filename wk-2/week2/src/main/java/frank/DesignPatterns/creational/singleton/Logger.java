package frank.DesignPatterns.creational.singleton;

/**
 * The Logger class implements a Singleton pattern to ensure only one instance of the Logger exists.
 * This class provides methods for writing log messages to the console.
 * The Logger instance can be accessed using the getInstance() method.
 */
public class Logger {

    private static Logger instance;

    /**
     * Private constructor to prevent instantiation from other classes.
     * Initializes resources if necessary.
     * i.e. Initialize any resources needed for logging (e.g., log files or streams)
     */
    private Logger() {}

    /**
     * Provides access to the single instance of the Logger.
     * This method ensures that only one instance is created even in multi-threaded environments.
     *
     * @return The single instance of the Logger.
     */
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();  // Create the single instance of Logger
                }
            }
        }
        return instance;
    }

    /**
     * Logs a generic message to the console.
     *
     * @param message The log message to be printed.
     */
    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    /**
     * Logs an informational message to the console.
     *
     * @param message The informational message to be printed.
     */
    public void info(String message) {
        System.out.println("INFO: " + message);
    }

    /**
     * Logs an error message to the console.
     *
     * @param message The error message to be printed.
     */
    public void error(String message) {
        System.err.println("ERROR: " + message);
    }
}

