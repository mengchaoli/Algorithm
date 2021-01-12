package String;

public class _844_BackspaceStringCompare {

    // Solution 1:
//    public boolean backspaceCompare(String S, String T) {
//        return helper(S).equals(helper(T));
//    }
//
//    private String helper(String S) {
//        StringBuilder sb1 = new StringBuilder();
//
//        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) == '#') {
//                if (sb1.length() > 0) {
//                    sb1.deleteCharAt(sb1.length() - 1);
//                }
//            } else {
//                sb1.append(S.charAt(i));
//            }
//        }
//
//        return sb1.toString();
//    }

    // Solution 2: O(1) space
    public boolean backspaceCompare(String S, String T) {
        int countS = 0, countT = 0;
        int i = S.length() - 1, j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    countS++;
                } else {
                    countS--;
                }
                i--;
            }

            char left = i < 0 ? '@' : S.charAt(i);

            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    countT++;
                } else {
                    countT--;
                }
                j--;
            }

            char right = j < 0 ? '@' : T.charAt(j);

            if (left != right) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}
