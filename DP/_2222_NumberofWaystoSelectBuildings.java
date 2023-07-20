package DP;

public class _2222_NumberofWaystoSelectBuildings {
    public long numberOfWays(String s) {
        int zero = 0, one = 0;
        long zeroOne = 0, oneZero = 0, total = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
                oneZero += one;
                total += zeroOne;
            } else {
                one++;
                zeroOne += zero;
                total += oneZero;
            }
        }

        return total;
    }
}
