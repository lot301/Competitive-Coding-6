import java.util.HashMap;

// Time Complexity :o(1)
// Space Complexity :O(n), number of messages
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : understanding heaps

// Your code here along with comments explaining your approach
public class LoggerRateLimiter {

    class Logger {
        HashMap<String, Integer> hashMap; //create hashmap
        /** Initialize your data structure here. */
        public Logger() {
            hashMap = new HashMap<String, Integer>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            //if message is not present in hashmap, add message and time stamp, then return true
            if(!hashMap.containsKey(message)){
                hashMap.put(message, timestamp);
                return true;
            }

            //if message is in hashmap, compute the difference of first time message saved to present message and if greater
            // than 10 update message and return true
            int previousTimeStamp = hashMap.get(message);
            if(timestamp - previousTimeStamp >= 10){
                hashMap.put(message, timestamp);
                return true;
            }
            //return false if both if conditions above fail
            return false;
        }
    }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */


}
