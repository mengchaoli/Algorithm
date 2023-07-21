package String;

import java.util.HashMap;
import java.util.Map;

public class _792_NumberofMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        char[] ch = s.toCharArray();
        int res = 0;
        for (String word: map.keySet()) {
            char[] temp = word.toCharArray();

            int i = 0, j = 0;

            while (i < ch.length && j < temp.length) {
                if (ch[i] == temp[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == temp.length) {
                res += map.get(word);
            }
        }

        return res;
    }
}
