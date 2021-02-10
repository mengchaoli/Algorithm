package Sort;

public class MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        mergeSort(nums, start, (start + end) / 2, temp);
        mergeSort(nums, (start + end) / 2 + 1, end, temp);
        merge(nums, start, end, temp);
    }

    private void merge(int[] nums, int start, int end, int[] temp) {
        int tempIndex = start;
        int mid = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;

        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[tempIndex++] = nums[leftIndex++];
            } else {
                temp[tempIndex++] = nums[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = nums[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[tempIndex++] = nums[rightIndex++];
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
