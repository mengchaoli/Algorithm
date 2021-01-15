package String;

public class _767_ReorganizeString {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        int max = 0, letter = 0;

        for (char c : S.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > max) {
                max = count[c - 'a'];
                letter = c - 'a';
            }
        }

        if (max > (S.length() + 1) / 2) {
            return "";
        }

        // Actually, only the most occurrence letter matters. That's why we dont need to sort the count array, we just need to settle down the most occurrence letter first
        int idx = 0;
        char[] res = new char[S.length()];
        for (int i = 0; i < max; i++) {
            res[idx] = (char) (letter + 'a');
            count[letter]--;
            idx += 2;
        }

        // Then settle down the rest
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (idx >= S.length()) {
                    idx = 1;
                }

                res[idx] = (char) (i + 'a');
                count[i]--;
                idx += 2;
            }
        }

        return String.valueOf(res);

    }
}
