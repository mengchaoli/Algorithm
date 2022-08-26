package Array;

import java.util.Random;

public class _384_ShuffleanArray {

    int[] nums;
    Random rdm;

    public _384_ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.rdm = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] copy = nums.clone();
        for (int i = nums.length - 1; i > 0; i--) {
            int idx = rdm.nextInt(i + 1);
            swap(copy, idx, i);
        }

        return copy;
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
