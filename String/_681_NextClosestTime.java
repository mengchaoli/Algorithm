package String;

import java.util.Arrays;

public class _681_NextClosestTime {
    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        char[] digits = new char[] {result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);

        result[4] = findNext(digits, result[4], (char)('9' + 1));
        if (result[4] > time.charAt(4))
            return String.valueOf(result);

        result[3] = findNext(digits, result[3], '5');
        if (result[3] > time.charAt((3)))
            return String.valueOf(result);

        result[1] = result[0] == '2' ? findNext(digits, result[1], '3') : findNext(digits, result[1], (char)('9' + 1));
        if (result[1] > time.charAt(1))
            return String.valueOf(result);

        result[0] = findNext(digits, result[0], '2');
        return String.valueOf(result);

    }

    private char findNext(char[] digits, char currDigit, char upperLimit) {
        if (currDigit == upperLimit)
            return digits[0];

        int idx = 0;
        while (idx < 4) {
            if (digits[idx] > currDigit && digits[idx] <= upperLimit)
                return digits[idx];
        }
        return digits[0];
    }
}
