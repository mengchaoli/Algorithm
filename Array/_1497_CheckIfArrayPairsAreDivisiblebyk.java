package Array;

/**
 * Idea :
 * Given 2 nums 'a' and 'b':
 * If a % k == x and b % k == k - x :
 * then (a + b) is divisible by k
 */

public class _1497_CheckIfArrayPairsAreDivisiblebyk {
    public boolean canArrange(int[] arr, int k) {
        int[] frequence = new int[k];
        for (int num : arr) {
            num %= k;
            if (num < 0) {
                num += k;
                frequence[num]++;
            }
        }

        if (frequence[0] % 2 != 0) return false;

        for (int i = 1; i <= k / 2; i++) {
            if (frequence[i] != frequence[k - i]) {
                return  false;
            }
        }

        return true;
    }
}
