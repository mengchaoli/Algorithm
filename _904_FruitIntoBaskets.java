/*
* In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?



Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.


Note:

1 <= tree.length <= 40000
0 <= tree[i] < tree.length
*
* */



//This is sliding window question. There are two ways to solve it. One is using hashmap, the other one does not.

import java.util.HashMap;
import java.util.Map;

public class _904_FruitIntoBaskets {

    //Solution one: using hashmap
    //Time O(N), Space O(N)

    //Explanation:
    // [i,j] is the sliding window, and it's the current longest window.
    //Suppose we found current longest window [i, j], then this length will be kept, because,
    //as j++, if the sliding window contains more than 2, then also we will do i++, so that is to say, the current longest length will be kept the same,
    //in another word, when [i,j] reached a maximum, it will not become smaller
    //on the other side, when j++, if the current window contains less than two, then i will not increase(because the if statement), in this way,
    // the longest length of sliding window will get updated.

    //The awesome part also includes:
    //As the explanation said, once it reaches the longest, it won't be shorter because as j++, i will also ++.
    //At the same time, this hashmap keeps all values and their count within range [i, j],
    // count.put(tree[i], count.get(tree[i]) - 1); this will reduce the count for tree[i], once its count is reduced to 0,
    //it will be removed from the hashmap. So the size of the hashmap is reduced by 1 which makes it possible for future fruit to come in.

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                //In Java you can simplify: if (count.get(tree[i]) == 0) count.remove(tree[i]); -> count.remove(tree[i], 0);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }

    //Solution two: not using hashmap
    //O(N) time, O(1) space

    //This solution uses two variables to represent the two fruits

    public int totalFruit(int[] tree) {
        // track last two fruits seen
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;

        for (int fruit : tree) {
            if (fruit == lastFruit || fruit == secondLastFruit)
                currMax++;
            else
                currMax = lastFruitCount + 1; // last fruit + new fruit

            if (fruit == lastFruit)
                lastFruitCount++;
            else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }

}
