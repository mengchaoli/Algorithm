package Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class _442_FindAllDuplicatesinanArray {
    //Solution 1:
//    public List<Integer> findDuplicates(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != i + 1) {
//                if (nums[nums[i] - 1] ==  nums[i]) {
//                    set.add(nums[i]);
//                    break;
//                } else {
//                    swap(nums, i, nums[i] - 1);
//                }
//            }
//        }
//        return new LinkedList<>(set);
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i] - 1;

            if (nums[idx] < 0) {
                res.add(idx + 1);
            }
            nums[i] = -nums[i];
        }
        return res;
    }
}
