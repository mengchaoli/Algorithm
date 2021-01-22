package Tree;

public class _1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
//        StringBuilder sb = new StringBuilder();
//
//        for (char c : S.toCharArray()) {
//            if (sb.length() != 0 && c == sb.charAt(sb.length() - 1)) {
//                sb.deleteCharAt(sb.length() - 1);
//            } else {
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();

        // Solution 2:
        char[] res = S.toCharArray();
        int i = 0;

        for (int j = 0; j < S.length(); j++, i++) {
            res[i] = res[j];
            if (i > 0 && res[i] == res[i - 1]) { // this means we found duplicate of 2 same characters
                i -= 2;
            }
        }

        return new String(res, 0, i);
    }
}
