package BinarySearch;

public class _4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0, high = m;
        int k = (m + n + 1) / 2;

        while (low <= high) {
            int partationX = low + (high - low) / 2;
            int partationY = k - partationX;

            int maxLeftX = partationX == 0 ? Integer.MIN_VALUE : nums1[partationX - 1];
            int minRightX = partationX == m ? Integer.MAX_VALUE : nums1[partationX];

            int maxLeftY = partationY == 0 ? Integer.MIN_VALUE : nums2[partationY - 1];
            int minRightY = partationY == n ? Integer.MAX_VALUE : nums2[partationY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partationX - 1;
            } else {
                low = partationX + 1;
            }
        }
        return 0;
    }
}
