package Array;

import java.util.LinkedList;
import java.util.List;

public class _229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return res;

        int count1 = 0, count2 = 0, number1 = nums[0], number2 = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == number1) {
                count1++;
            } else if (nums[i] == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i  = 0; i < nums.length; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }

        if (count1 > nums.length / 3)
            res.add(count1);
        if (count2 > nums.length / 3)
            res.add(count2);

        return res;
    }
}
