import java.util.Arrays;
import java.util.Comparator;

/**
 * Time: O(nklog(n)), Space: O(n)
 * n is the length of nums, k is the average length of each String in s_num
 * Merge sort has O(log(n)) levels, at each level during the merge phase we do O(n) comparisons. If we assume that a comparison between two elements costs O(1) time then the total time complexity for the sort is O(nlogn).
 * If a comparison costs O(k) time then one merge phase costs O(n * k) time because we do O(n) comparisons where one comparison costs O(k) time. Since we have O(log(n)) merge phases the total time complexity for the sort is O(k * n * log(n)) time.
 *
 * In other words, the time complexity of the sort is O(cost_of_one_comparison * nlogn).
 * */

public class _179_LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }

        String[] s_num = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            s_num[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s_num, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String order1 = s1 + s2;
                String order2 = s2 + s1;

                return order2.compareTo(order1);
            }
        });

        if (s_num[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(s_num[i]);
        }

        return sb.toString();
    }
}
