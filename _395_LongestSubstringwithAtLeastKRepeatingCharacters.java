public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for (int i : chars) {
            if (i > 0 && i < k) {
                flag = false;
                break;
            }
        }

        // if all characters' count in this string/substring are greater than k, then this is a qualified string/substring
        if (flag) {
            return s.length();
        }

        // else
        int start = 0, current = 0, result = 0;
        while (current < s.length()) {
            if (chars[s.charAt(current) - 'a'] < k) { // this means we met a unfrequent(whose count is under k) character, then we are going to check the substring before this character
                result = Math.max(result, longestSubstring(s.substring(start, current), k));
                start = current + 1; // move start to next character, so we can record the starting position of next snippet to check
            }
            current++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
