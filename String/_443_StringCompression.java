package String;

public class _443_StringCompression {
    public int compress(char[] chars) {
        int idxAns = 0, idx = 0;

        while (idx < chars.length) {
            int count = 0;
            char currentChar = chars[idx];

            while (idx < chars.length && chars[idx] == currentChar) { // Line 8 ~ 11 is a good solution to handle those edge cases (idx and chars.length). So this way we dont need to use chars[idx] to compare with chars[idx + 1] or chars[idx - 1]
                idx++;
                count++;
            }

            chars[idxAns++] = currentChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[idxAns++] = c;
                }
            }
        }

        return idxAns;
    }
}
