package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (!map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), end);
                res = Math.max(res, end - start + 1);
            } else {
                int newStart = map.get(s.charAt(end)) + 1;
                for (int i = start; i < newStart; i++) {
                    map.remove(s.charAt(i));
                }
                start = newStart;
                map.put(s.charAt(end), end);
            }
            end++;
        }
        return res;
    }
}
