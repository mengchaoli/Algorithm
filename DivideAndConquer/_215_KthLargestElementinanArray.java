package DivideAndConquer;

import java.util.PriorityQueue;

public class _215_KthLargestElementinanArray {
    // Solution 1: PriorityQueue
    // Time: O(NlogK)
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num : nums) {
//            pq.offer(num);
//
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//
//        return pq.peek();
//    }

    // Solution 2: Quick Select. Quick Select algorithm is used to solve Kth largest/smallest number in an unsorted array
    // Time: average O(N), worst case O(N^2)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int i = start, j = end;
        int pivot = nums[(start + end) / 2];

        while (i <= j) {
            while (i <= j && nums[i] > pivot) { // here we are looking for kth largest element, so we keep large value(compare to pivot) on the left, and move small value to right
                i++;
            }

            while (i <= j && nums[j] < pivot) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }

        // after the partition process above, the array is divided into 3 parts: start-j, j-i, i-end
        // it is possible that between j and i, there is an element, because in line 48, if i == j, and then i++, j--, so there is an element in between j and i
        // next is to determine which part we should go
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k); // here we are going to handle the left part, k locates in the left part. And we still need to look for the kth one on the left part
        }

        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start)); // here we already discard (i-start)个element, we just need to look for k-(i-start) on the right part
        }

        // if reaches here, means there is an element between j and i, and that is the kth one which is what we are looking for
        return nums[j + 1];
    }
}
