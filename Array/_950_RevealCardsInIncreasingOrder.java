package Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _950_RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        //Solution 1(My Solution):
        //         Arrays.sort(deck);
        //         int len = deck.length;
        //         LinkedList<Integer> list = new LinkedList<>();
        //         list.add(deck[len - 1]);
        //         //list.addFirst(deck[len - 2]);

        //         for (int i = len - 2; i >= 0; i--) {
        //             int tail = list.get(list.size() - 1);
        //             list.remove(list.size() - 1);
        //             list.addFirst(tail);
        //             list.addFirst(deck[i]);
        //         }

        //         int[] res = list.stream().mapToInt(i->i).toArray();

        //         return res;

        //Solution 2(Imitation)
        Arrays.sort(deck);
        int len = deck.length;
        int[] res = new int[len];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            queue.add(i);
        }

        int idx = 0;

        while (!queue.isEmpty()){
            int p = queue.poll();
            res[p] = deck[idx++];
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }

        return res;
    }
}
