import java.util.HashMap;
import java.util.Map;

public class _359_LoggerRateLimiter {
    private final Map<String, Integer> hm;

    /** Initialize your data structure here. */
    public _359_LoggerRateLimiter() {
        hm = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int timeStampAllowed = hm.getOrDefault(message, 0);

        if (timestamp >= timeStampAllowed) {
            hm.put(message, timestamp + 10);
            return true;
        } else {
            return false;
        }
    }
}
