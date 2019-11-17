public class _1007_MinimumDominoRotationsForEqualRow {

    //Soluton 1:
    //Count the occurrence of all numbers in A and B,
    //and also the number of domino with two same numbers.
    //
    //Try all possibilities from 1 to 6.
    //If we can make number i in a whole row,
    //it should satisfy that countA[i] + countB[i] - same[i] = n
    //
    //Take example of
    //A = [2,1,2,4,2,2]
    //B = [5,2,6,2,3,2]
    //
    //countA[2] = 4, as A[0] = A[2] = A[4] = A[5] = 2
    //countB[2] = 3, as B[1] = B[3] = B[5] = 2
    //same[2] = 1, as A[5] = B[5] = 2
    //
    //We have countA[2] + countB[2] - same[2] = 6,
    //so we can make 2 in a whole row.
    //
    //Time O(N), Space O(1)

    public int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        int len = A.length;

        for (int i = 0; i < len; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) {
                same[A[i]]++;
            }
        }

        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == len) {
                return len - Math.max(countA[i], countB[i]);
            }
        }
        return -1;
    }

    //Solution 2:
    //下面这个solution能成功的原因是：我们只要取数组A和数组B中对应位置的任意一个数值作为标准就可以了。
    //在这里我们取A[0]和B[0]（随便取），因为如果要满足题目描述中的条件：“all the values in A are the same, or all the values in B are the same.”，
    // 这个same的value必然是A[0]或者B[0]中的一个。要么所有的值都转化成A[0]要么所有的值都转化成B[0]。
    public int minDominoRotations_2(int[] A, int[] B) {
        int rotations = helper(A[0], A, B);
        if (rotations != -1 || A[0] == B[0]) {
            return rotations;
        }
        else {
            return helper(B[0], A, B);
        }
    }

    private int helper(int x, int[] A, int[] B) {
        int timeA = 0, timeB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != x && B[i] != x) { //这里，如果A[i]和B[i]都没法等于x，那么这一对数组就不可能满足题目的要求
                return -1;
            }
            if (A[i] != x) {
                timeA++;
            } else {
                timeB++;
            }
        }

        return timeA > timeB ? timeB : timeA;
    }

}
