package DP;

/**
 * there are 3 states for each day. for today (index i in the array), it's either
 * we buy this stock --> hold state, and for future days if we don't sell stock, we still in hold state
 * we sell this stock --> sold state, and after we sell a stock, next day we must go into cooled state
 * we just sold and need to cooldown --> cooled state, and for future days if we don't buy stock, we still in cooled state
 * */

public class _309_BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        // for this initial value, we need to be careful and think about it.
        int hold = Integer.MIN_VALUE, sold = 0, cooled = 0;

        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            // make a replica for those three values because later we are gonna change them, and we need the old value as reference
            int hold2 = hold, sold2 = sold, cooled2 = cooled;

            // state transition:

            // if today is a hold day, previously there can only be 2 situations (previous' hold -> today's hold) or (cooled -> today's hold)
            // and if previously it was cooled, today we buy the stock so we need to minus the price (p) from previously stored the max cooled value
            hold = Math.max(hold2, cooled2 - p);
            // if today we sell the stock, there is only one way to enter this state, which is previously we bought (hold) a stock and today we sell, we get
            // the profit, so plus p
            sold = hold2 + p;
            // there are two situations if today is also a cooled day. this means we don't buy and sell any stock and today's max profit is determined by previously
            // sold's max value and cooled's max value
            cooled = Math.max(sold2, cooled2);
        }

        // final result should only exist between sold or cooled.
        return Math.max(sold, cooled);
    }
}
