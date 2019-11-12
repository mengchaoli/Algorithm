/*
* For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

Given N, return any beautiful array A.  (It is guaranteed that one exists.)



Example 1:

Input: 4
Output: [2,1,4,3]
Example 2:

Input: 5
Output: [3,1,2,5,4]


Note:

1 <= N <= 1000
* */

import java.util.LinkedList;
import java.util.List;

public class _932_BeautifulArray {
    public int[] beautifulArray(int N) {
        List<Integer> res = new LinkedList<>();
        res.add(1);

        while (res.size() < N) {
            List<Integer> temp = new LinkedList<>();
            for (int i : res) {
                if (i * 2 - 1 <= N)
                    temp.add(i * 2 - 1);
            }
            for (int i : res) {
                if (i * 2 <= N)
                    temp.add(i * 2);
            }
            res = temp;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
