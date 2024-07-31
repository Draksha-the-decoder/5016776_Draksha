public class SingletonPatternExample {
    public static class Logger {
        private static volatile Logger instance = null;
        private Logger() {}
        public static Logger getInstance() {
            if (instance == null) {
                    synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                }
            }
            return instance;
        }
        public void log(String message) {
            System.out.println("Log message: " + message);
        }
    }
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message.");
        logger2.log("Second log message.");

        if (logger1 == logger2) {
            System.out.println("only one instance of Logger is created and used across the application");
        } else {
            System.out.println("different instances of logger created.");
        }
    }
}

// OUTPUT

// Log message: First log message.
// Log message: Second log message.
// only one instance of Logger is created and used across the application