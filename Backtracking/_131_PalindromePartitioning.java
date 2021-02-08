package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class _131_PalindromePartitioning {

    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new LinkedList<>();
        helper(s, 0, res, new LinkedList<>());
        return res;
    }

    private void helper(String s, int startIdx, List<List<String>> res, List<String> list) {
        if (startIdx == s.length()) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            if (isPal(s, startIdx, i)) {
                list.add(s.substring(startIdx, i + 1));
                helper(s, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int low, int high) {
        if (low == high) {
            return true;
        }

        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }

        return true;
    }
}
