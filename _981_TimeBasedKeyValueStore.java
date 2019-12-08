import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _981_TimeBasedKeyValueStore {

    class Node {
        int timestamp;
        String val;
        public Node(int timestamp, String val) {
            this.timestamp = timestamp;
            this.val = val;
        }
    }

    Map<String, List<Node>> map;

    public _981_TimeBasedKeyValueStore() { // public TimeMap(){}
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Node>());
        }

        map.get(key).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Node> list = map.get(key);

        //Binary Search
        int low = 0, high = list.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).timestamp == timestamp) {
                return list.get(mid).val;
            } else if (list.get(mid).timestamp < timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (list.get(high).timestamp <= timestamp) return list.get(high).val;
        else if(list.get(low).timestamp <= timestamp) return list.get(low).val;
        return "";
    }
}
