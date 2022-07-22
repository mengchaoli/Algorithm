package Array;

import java.util.HashMap;

public class _2342_MaxSumofaPairWithEqualSumofDigits {
    public int maximumSum(int[] nums) {
        int result = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int item : nums) {
            int key = sumOfDigits(item);

            if (!hm.containsKey(key)) {
                hm.put(key, item);
            } else {
                result = Math.max(result, hm.get(key) + item);
                hm.put(key, Math.max(hm.get(key), item));
            }
        }

        return result;
    }

    private int sumOfDigits(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }
}
