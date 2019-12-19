import java.util.Arrays;

public class _322_CoinChange {

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        //sort the array in desc order, coz we are going to use the biggest coin(and the most amount of that biggest coin first, which is showed in the dfs for loop) first
        Arrays.sort(coins);
        for(int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - i - 1];
            coins[coins.length - i - 1] = temp;
        }

        helper(coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void helper(int[] coins, int amount, int s, int count) {
        int coin = coins[s];

        if (s == coins.length) {
            if (amount % coin == 0) {
                ans = Math.min(ans, count + amount / coin);
            }
        } else {
            for (int k = amount / coin; k >= 0 && count + k < ans; k--) { // here we restrict "count + k < ans", this is 强减枝, this means that if the current count (count + k) is bigger than the answer, there is no need to go further.
                helper(coins, amount - k * coin, s + 1, count + k);
            }
        }
    }
}
