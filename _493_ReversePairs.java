import java.util.Arrays;

public class _493_ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int count = 0;
        int mid = start + (end - start) / 2;

        count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        Arrays.sort(nums, start, mid + 1);
        Arrays.sort(nums, mid + 1, end + 1);

        int p = start, q = mid + 1;

        while (p <= mid && q <= end) {
            if ((long) nums[p] > (long) 2 * nums[q]) {
                count += (mid - p + 1);
                q++;
            } else {
                p++;
            }
        }

        return count;
    }
}
