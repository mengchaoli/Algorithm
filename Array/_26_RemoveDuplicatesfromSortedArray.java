package Array;

public class _26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
