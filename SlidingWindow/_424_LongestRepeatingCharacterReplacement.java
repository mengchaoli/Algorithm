package SlidingWindow;

public class _424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int res = 0, maxCount = 0, i = 0;
        int[] count = new int[26];

        for (int j = 0; j < s.length(); j++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(j) - 'A']);

            if (maxCount + k < i - j + 1) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
