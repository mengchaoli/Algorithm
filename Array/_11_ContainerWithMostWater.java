//wo pointers must be the first approach you think about when the problem is about finding a subarray/substring/or two indices start and end.
// After that you need to know the direction of your pointers : either start and end are increasing, or start is increasing and end is decreasing.
// In this problem the first alternative may cause a loss of the right pointer, this is why we go with the second

package Array;

public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                int prevHeight = height[left];
                while (height[left] <= prevHeight) {
                    left++;
                }
            } else {
                int prevHeight = height[right];
                while (height[right] <= prevHeight) {
                    right--;
                }
            }
        }
        return max;
    }
}
