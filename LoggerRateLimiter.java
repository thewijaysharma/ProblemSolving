package ProblemSolving;

import java.util.HashMap;

public class LoggerRateLimiter {

    /**
     * Your Logger object will be instantiated and called as such:
     * Logger obj = new Logger();
     * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
     */
    static class Logger {
        static HashMap<String, Integer> logMap = new HashMap<>();

        public Logger() {
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            boolean shouldPrint = true;
            if(Logger.logMap.containsKey(message)){
                int prevTimestamp = Logger.logMap.get(message);
                shouldPrint = timestamp - prevTimestamp >= 10;
            }

            if(shouldPrint)  logMap.put(message, timestamp);


            return shouldPrint;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(100, "bug"));
        System.out.println(logger.shouldPrintMessage(111, "bug"));

    }

}
