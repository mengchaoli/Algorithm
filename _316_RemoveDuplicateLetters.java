public class _316_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        char[] ch = s.toCharArray();

        for (char c : ch) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : ch) {
            int index = c - 'a';
            count[index]--;
            if (visited[index]) {
                continue;
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            visited[c - 'a'] = true;
        }

        return sb.toString();
    }
}
