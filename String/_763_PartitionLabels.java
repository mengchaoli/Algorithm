package String;

import java.util.LinkedList;
import java.util.List;

public class _763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) { // means we meet the label
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }
}
