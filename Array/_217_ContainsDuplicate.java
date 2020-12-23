package Array;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();

        for (int num : nums) {
            if (!hs.add(num)) {
                return true;
            }
        }

        return false;
    }
}
