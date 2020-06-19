package String;

import java.util.HashSet;

public class _409_LongestPalindrome {
    //Solution1:
//    public int longestPalindrome(String s) {
//        int[] count = new int[52];
//        int ans = 0;
//        boolean hasOdd = false;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (Character.isUpperCase(s.charAt(i))) {
//                count[s.charAt(i) - 'A' + 26]++;
//            } else {
//                count[s.charAt(i) - 'a']++;
//            }
//        }
//
//        for (int i = 0; i < 52; i++) {
//            if (count[i] % 2 == 0) {
//                ans += count[i];
//            } else {
//                ans += count[i] - 1;
//                hasOdd = true;
//            }
//        }
//
//        return hasOdd ? ans + 1 : ans;
//    }

    //Solution2:
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                count++;
                hs.remove(s.charAt(i));
            } else {
                hs.add(s.charAt(i));
            }
        }

        return hs.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
