package BinarySearch;

import java.util.Arrays;

public class _1552_MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1];

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (canPut(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canPut(int[] position, int m, int gap) {
        int count = 1;
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= gap) {
                count++;
                lastPosition = position[i];
            }
        }

        return count >= m;
    }
}
