package BinarySearch;


/**
 * When the question is an sorted array, consider BINARY SEARCH!!!!!
 * */
public class _1060_MissingElementinSortedArray {

    //Solution 1:
//    public int missingElement(int[] nums, int k) {
//        if (missing(nums, nums.length - 1) < k) {
//            return nums[nums.length - 1] + missing(nums, nums.length - 1);
//        }
//
//        int idx = 0;
//        while (missing(nums, idx) < k) {
//            idx++;
//        }
//
//        return nums[idx - 1] + missing(nums, idx - 1);
//    }
//
//    // this is to help calculate how many numbers are missing at index idx
//    private int missing(int[] nums, int idx) {
//        return nums[idx] - nums[0] - idx;
//    }

    // Solution 2: Binary Search
    public int missingElement(int[] nums, int k) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (missing(nums, mid) == k) {
                return nums[mid] - 1;
            }
            if (missing(nums, mid) < k) {
                start = mid + 1;
            } else if (missing(nums, mid) > k) {
                end = mid - 1;
            }
        }

        if (missing(nums, start) < k) {
            return nums[start] + k - missing(nums, start);
        } else {
            return nums[start - 1] + k - missing(nums, start - 1);
        }
    }

    private int missing(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }
}
