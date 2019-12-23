import java.util.Random;

public class _528_RandomPickwithWeight {

    Random random;
    int[] wSum;

    public _528_RandomPickwithWeight(int[] w) {
        this.random = new Random();
        wSum = new int[w.length];
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        wSum = w;
    }

    public int pickIndex() {
        int len = wSum.length;
        int idx = random.nextInt(wSum[len - 1]) + 1;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (wSum[mid] == idx) {
                return mid;
            } else if (wSum[mid] < idx) {
                left = mid + 1;
            } else {
                right = mid;  // here we need to be careful
            }
        }
        return left;
    }
}
