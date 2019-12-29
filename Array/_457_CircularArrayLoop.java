package Array;

public class _457_CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 1 && nums[0] == -1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;;
            }
            int j = i, k = getIdx(i, nums);
            while (nums[i] * nums[k] > 0 && nums[i] * nums[getIdx(k, nums)] > 0) {
                if (j == k) {
                    if (j == getIdx(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIdx(j, nums);
                k = getIdx(getIdx(k, nums), nums); // here we set fast pointer to go two steps forward
            }

            //no circle, set elements to zero, and if we find zero, we no need to check loop starting at that idx, coz there wont be
            j = i;
            int val = nums[i];
            while (val * nums[j] > 0) {
                int next = getIdx(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

    private int getIdx(int i , int[] nums) {
        int len = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % len : len + ((i + nums[i]) % len);
    }
}
