package BitOperation;

import java.util.LinkedList;
import java.util.List;

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
