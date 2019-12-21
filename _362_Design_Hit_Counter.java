import java.util.LinkedList;
import java.util.Queue;

public class _362_Design_Hit_Counter {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public _362_Design_Hit_Counter() {
        queue = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        Queue<Integer> temp = new LinkedList<>(queue);
        while (temp.size() > 0 && temp.peek() <= timestamp - 300) {
            temp.remove();
        }
        return temp.size();
    }
}
