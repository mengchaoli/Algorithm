package BinarySearch;

public class _875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = getMax(piles);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canEatAll(piles, mid, h)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    private boolean canEatAll(int[] piles, int speed, int h) {
        int count = 0;
        for (int pile : piles) {
            int hour = pile / speed;
            if (pile % speed != 0) {
                hour++;
            }
            count += hour;
        }

        return count <= h;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        return max;
    }
}
