package String;

public class _5_LongestPalindromicSubstring {

    int maxLen, lo;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            expandPalindrome(s, i, i);
            expandPalindrome(s, i, i + 1);
        }

        return s.substring(lo, lo + maxLen);

    }

    public void expandPalindrome(String s, int i, int j ) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (maxLen < (j - i - 1)) {
            maxLen = j - i - 1;
            lo = i + 1;
        }
    }
}
