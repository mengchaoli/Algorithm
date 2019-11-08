/*
* In an array A of 0s and 1s, how many non-empty subarrays have sum S?



Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation:
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]


Note:

A.length <= 30000
0 <= S <= A.length
A[i] is either 0 or 1.
* */

public class _930_BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] count = new int[A.length + 1];
        int psum = 0, total = 0;
        count[0] = 1;

        for (int i : A) {
            psum += i;

            if (psum >= S) {
                total += count[psum - S];
            }

            count[psum]++;
        }

        return total;
    }
}
