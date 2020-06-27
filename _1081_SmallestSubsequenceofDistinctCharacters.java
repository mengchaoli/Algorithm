public class _1081_SmallestSubsequenceofDistinctCharacters {
    public String smallestSubsequence(String text) {
        boolean[] visited = new boolean[26];
        int[] count = new int[26];
        char[] ch = text.toCharArray();

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

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0){
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            visited[index] = true;
            sb.append(c);
        }

        return sb.toString();
    }
}
