package Sort;

// If you want to find something, you can use loop, until you meet some condition, means you find that.
public class QuickSort {
//    private void solution(int[] A) {
//        if (A == null || A.length == 0) {
//            return;
//        }
//
//        quickSort(A, 0, A.length - 1);
//    }
//
//    private void quickSort(int[] A, int start ,int end) {
//        if (start >= end) {
//            return;
//        }
//
//        int left = start, right = end;
//        // pivot, we pick value, not index
//        int pivot = A[(start + end) / 2];
//
//        // 2. left <= right, not <
//        while (left <= right) {
//            // 3. A[left] < pivot, not <=
//            while (left <= right && A[left] < pivot) {
//                left++;
//            }
//            while (left <= right && A[right] > pivot) {
//                right--;
//            }
//
//            if (left <= right) {
//                int temp = A[left];
//                A[left] = A[right];
//                A[right] = temp;
//                left++;
//                right--;
//            }
//        }
//
//        quickSort(A, start, right);
//        quickSort(A, left, end);
//    }
    private void solution(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start ,int end) {
        if (start >= end) {
            return;
        }

        // pivot is value, not index;
        int pivot = A[(start + end) / 2];
        int left = start, right = end;

        // left <= right
        while (left <= right) {
            // A[left] < pivot
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
