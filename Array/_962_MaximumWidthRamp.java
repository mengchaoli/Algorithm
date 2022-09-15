package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _962_MaximumWidthRamp {
    // time: O(nlogn)
//    public int maxWidthRamp(int[] nums) {
//        List<Integer> list = new ArrayList<>();
//
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            // create a decreasing stack
//            if (list.size() == 0 || nums[i] < nums[list.get(list.size() - 1)]) {
//                list.add(i);
//            } else {
//                // use the binary search to find the one the is smaller than nums[i]. those that are before should be larger than nums[i] coz it is a decreasing
//                int left = 0, right = list.size() - 1;
//                while (left < right) {
//                    int mid = left + (right - left) / 2;
//                    if (nums[list.get(mid)] > nums[i]) {
//                        left = mid + 1;
//                    } else {
//                        right = mid;
//                    }
//                }
//                res = Math.max(res, i - list.get(left));
//            }
//        }
//
//        return res;
//    }

    // solution 2: Time: O(n)
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = nums.length - 1; i > res; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }
}
