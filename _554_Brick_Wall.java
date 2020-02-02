import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _554_Brick_Wall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int max = 0;
        
        for (List<Integer> row : wall) {
            int pre = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                pre += row.get(i);
                int time = map.getOrDefault(pre, 0);
                
                
                map.put(pre, time + 1);
                max = Math.max(max, time + 1);
            }
        }
        return wall.size() - max;
    }
}