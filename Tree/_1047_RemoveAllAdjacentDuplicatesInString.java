package Tree;

public class _1047_RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (sb.length() != 0 && c == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
