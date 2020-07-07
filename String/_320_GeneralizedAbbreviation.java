package String;

import java.util.LinkedList;
import java.util.List;

public class _320_GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        DFS(word.toCharArray(), res, new StringBuilder(), 0, 0);
        return res;
    }

    private void DFS(char[] word, List<String> res, StringBuilder sb, int i, int num) {
        int len = sb.length();
        if (i == word.length) {
            if (num != 0) {
                sb.append(num);
            }
            res.add(sb.toString());
        } else {
            // abbreviate
            DFS(word, res, sb, i + 1, num + 1);

            // not abbreviate, first append the number that calculated before current char, then append current char
            // to stringbuilder
            if (num != 0) {
                sb.append(num);
            }
            DFS(word, res, sb.append(word[i]), i + 1, 0);
        }

        sb.setLength(len);
    }
}
