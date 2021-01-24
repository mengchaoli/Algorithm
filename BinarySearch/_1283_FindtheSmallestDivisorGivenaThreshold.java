package BinarySearch;

public class _1283_FindtheSmallestDivisorGivenaThreshold {

    // Time: O(NlogM), where M = Max(num : nums), N = nums.length;
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = (int)1e6;

        while (left < right) {
            int mid = left + (right - left) / 2;  // This is a good way to implement Math.ceil(), "ceil(x) = int(x + 0.9999), so I add a big float (m-1)/m"
            int sum = 0;

            for (int n : nums) {
                sum += (n + mid - 1) / mid;
            }

            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
