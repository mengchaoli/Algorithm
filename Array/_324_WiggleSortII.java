package Array;

import java.util.Arrays;

public class _324_WiggleSortII {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int left = (n + 1) / 2 - 1;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[left--];
            } else {
                nums[i] = copy[right--];
            }
        }
    }
}
