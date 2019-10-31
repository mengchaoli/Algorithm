/*
* Given an array A, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.



Example 1:

Input: [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]


Note:

2 <= A.length <= 30000
0 <= A[i] <= 10^6
It is guaranteed there is at least one way to partition A as described.
*
* */

//My original solution is to iterate the input array twice, one time from left to right, record the max value of the left.
//the other one from right to left, record the min value of the right. And we just need to iterate the two arrays and find out
//at what point we got leftMax[i]  <= rightMin[i]

//Better solution is:
//suppose the original left subarray is from 0 to partitionIdx, the max value of that is localMax.
// If it is a valid partition, every value from partitionIdx + 1 to end should be >= localMax.
// But if we find a value in the right part, a[i], is smaller than localMax, which means the partition is not correct and we have to incorporate a[i] to form the left subarray.
// So the partitionIdx is set to be i, and we have to recalculate the max value of the new left subarray.(recorded in max)
public class _915_PartitionArrayintoDisjointIntervals {

    public int partitionDisjoint(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            } else max = Math.max(max, a[i]);
        return partitionIdx + 1;
    }

    //My solution:
//    public int partitionDisjoint(int[] A) {
//        int N = A.length;
//        int[] leftMax = new int[N];
//        int[] rightMin = new int[N];
//        int max = A[0], min = A[N - 1];
//
//        for (int i = 0; i < N; i++) {
//            if (max <= A[i]) {
//                max = A[i];
//            }
//            leftMax[i] = max;
//        }
//
//        for (int i = N - 1; i >= 0; i--) {
//            rightMin[i] = min;
//            if (min >= A[i]) {
//                min = A[i];
//            }
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (leftMax[i]  <= rightMin[i]) {
//                return i + 1;
//            }
//        }
//        return 0;
//    }
}
