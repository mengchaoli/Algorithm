//Solution:
//The logic behind this solution is that, we can satisfy those customers that come when the owner is not grumpy, where we use satisfied to
//record that. So we just need to find out where to apply the X so that we can satisfy more customers as possible(include as much customers that come when owner is grumpy as possible).
//So we use a sliding window "win" and count the extra satisfied customers. If the window's length is over X, we need to deduct the left element to keep window's size as X
//And use maxMakeSatisfied to record the maximum extra "made" satisfied customers. Add satisfied + maxMakeSatisfied there two and we get the answer.

public class _1052_GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0, maxMakeSatisfied = 0;

        for (int i = 0, win = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) satisfied += customers[i];
            else win += customers[i];

            if (i >= X) {
                win -= grumpy[i - X] * customers[i - X];
            }

            maxMakeSatisfied = Math.max(maxMakeSatisfied, win);
        }
        return satisfied + maxMakeSatisfied;
    }
}
