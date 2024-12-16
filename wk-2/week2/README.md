
## Singleton
- `Private static instance`: The instance variable holds the single instance of the Logger class.
- `Private constructor` 🔒 : This prevents any external class from instantiating the Logger directly.
- `Thread-safe singleton initialization` 🧵🔐: The `getInstance()` method is thread-safe, ensuring that only one instance is created even in multi-threaded environments. The synchronized block inside the method ensures that only one thread can initialize the instance at a time.
- `Logging methods`: The `log()` method simply prints log messages to the console. Additional methods (`info()`, `error()`) have been added for different log levels.