import java.util.LinkedList;
import java.util.List;

public class _228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        int len = nums.length;

        int idx = 0;

        while (idx < len) {
            int p = idx;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[idx]);
            while (idx + 1 < len && nums[idx + 1] == nums[idx] + 1) {
                idx++;
            }
            //check if p == idx
            if (idx != p) {  //this means there are increasing range, and we just need to save the last number which is the end of this range
                sb.append("->");
                sb.append(nums[idx]);
            }
            idx++;
            ans.add(sb.toString());
        }
        return ans;
    }
}
