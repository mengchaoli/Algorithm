package SlidingWindow;

import java.util.Arrays;

public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int result = 0;
        int[] counts = new int[26];

        for (int i = 1; i <= 26; i++) {
            Arrays.fill(counts, 0);
            int start = 0, end = 0, uniqueCharacter = 0;

            while (end < s.length()) {
                boolean valid = true;
//                if (counts[s.charAt(end) - 'a'] == 0) {
//                    counts[s.charAt(end) - 'a']++;
//                    uniqueCharacter++;
//                    end++;
//                } else {
//                    counts[s.charAt(end) - 'a']++;
//                    end++;
//                }
                if (counts[s.charAt(end++) - 'a']++ == 0) {
                    uniqueCharacter++;
                }

                // we need exactly i unique characters for each round, so we need to shrink the window from start, until there is only i unique characters
                while (uniqueCharacter > i) {
                    if (counts[s.charAt(start++) - 'a']-- == 1) {
                        uniqueCharacter--;
                    }
                }

                for (int j = 0; j < 26; j++) {
                    if (counts[j] > 0 && counts[j] < k) {
                        valid = false;
                    }
                }

                if (valid) {
                    result = Math.max(result, end - start);
                }
            }
        }
        return result;
    }
}
