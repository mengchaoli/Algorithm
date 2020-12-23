package BitOperation;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution: generate the sequence iteratively. when n=3, we can get the result based on n=2, that's the first for loop
 * when i++, basically we need to double the size of res, that's the second for loop, k from size-1 to 0. And this time we just need to turn on the highest bit, from res.get(size-1) to res.get(0)
 * From res.get(0) to res.get(size-1), highest bit is 0, and [res.add(res.get(k) | 1 << i] will turn the highest bit to 1, also they will follow the restriction which is only on bit is different.
* */
public class _89_GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        res.add(0);

        for (int i = 0; i < n; i++) {
            int size = res.size();

            for (int k = size - 1; k >= 0; k--) {
                res.add(res.get(k) | 1 << i);
                // res.add(res.get(k) + (1 << i));
            }
        }

        return res;
    }
}
