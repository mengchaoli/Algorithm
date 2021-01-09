package String;

import java.util.Arrays;

public class _833_indAndReplaceinString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; i++) {
            if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) {
                match[indexes[i]] = i;
            }
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < N) {
            if (match[idx] >= 0) {
                sb.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            } else {
                sb.append(S.charAt(idx++));
            }
        }

        return sb.toString();
    }
}

