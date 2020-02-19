/**
* Constraints:
    arr1.length, arr2.length <= 1000
    0 <= arr1[i], arr2[i] <= 1000
    Each arr2[i] is distinct.
    Each arr2[i] is in arr1.
**/

public class _1122_RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1) {
            cnt[n]++;
        }
        int i = 0;

        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }

        for (int j = 0; j < 1001; j++) {
            while (cnt[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }
}
