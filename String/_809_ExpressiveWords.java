package String;

public class _809_ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isStretchy(S, word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isStretchy(String S, String word) {
        int i, j;

        for (i = 0, j = 0; i < S.length() && j < word.length(); i++, j++) {
            if (S.charAt(i) != word.charAt(j)) {
                break;
            }

            int step1 = 1, step2 = 1;
            while (i < S.length() - 1 && S.charAt(i) == S.charAt(i + 1)) {
                step1++;
                i++;
            }

            while (j < word.length() - 1 && word.charAt(j) == word.charAt(j + 1)) {
                step2++;
                j++;
            }

            if (step1 < 3 && step1 != step2 || step1 >= 3 && step1 < step2) {
                break;
            }
        }

        return i == S.length() && j == word.length();
    }
}
