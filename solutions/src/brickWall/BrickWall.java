package brickWall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                sum += wall.get(i).get(j);
                int c = countMap.getOrDefault(sum, 0) + 1;
                countMap.put(sum, c);
                ans = Math.max(ans, c);
            }
        }
        return wall.size() - ans;
    }
}
