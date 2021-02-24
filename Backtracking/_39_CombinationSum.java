package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        backtracking(candidates, target, res, new LinkedList<Integer>(), 0);
        return res;
    }

//    private void backtracking(int[] cand, int remain, List<List<Integer>> res, List<Integer> list, int idx) {
//        if (remain < 0) {
//            return;
//        }
//        if (remain == 0) {
//            res.add(new LinkedList<>(list));
//            return;
//        }
//
//        for (int i = idx; i < cand.length; i++) {
//            list.add(cand[i]);
//            backtracking(cand, remain - cand[i], res, list, i);
//            list.remove(list.size() - 1);
//        }
//    }

    // another way to achieve above:
    private void backtracking(int[] cand, int remain, List<List<Integer>> res, List<Integer> list, int idx) {
        if (remain == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if (remain < 0 || idx >= cand.length) {
            return;
        }
        int max = remain / cand[idx];
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < i; j++) {
                list.add(cand[idx]);
            }
            backtracking(cand, remain - i * cand[idx], res, list, idx + 1);
            for (int j = 0; j < i; j++) {
                list.remove(list.size() - 1);
            }
        }
    }
}
