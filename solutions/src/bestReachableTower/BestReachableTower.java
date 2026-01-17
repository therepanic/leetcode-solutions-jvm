package bestReachableTower;

import java.util.ArrayList;
import java.util.List;

public class BestReachableTower {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        List<List<Integer>> all = new ArrayList<>();
        for (int i = 0; i < towers.length; i++) {
            if (Math.abs((towers[i][0] - center[0])) + Math.abs((towers[i][1] - center[1])) <= radius) {
                all.add(List.of(towers[i][0], towers[i][1], towers[i][2]));
            }
        }
        all.sort((p1, p2) -> {
            if (!p1.get(2).equals(p2.get(2))) {
                return Integer.compare(p2.get(2), p1.get(2));
            }
            if (!p1.get(0).equals(p2.get(0))) {
                return Integer.compare(p1.get(0), p2.get(0));
            }
            return Integer.compare(p1.get(1), p2.get(1));
        });
        if (all.isEmpty()) {
            return new int[] {-1, -1};
        } else {
            return new int[] {all.getFirst().get(0), all.getFirst().get(1)};
        }
    }
}
