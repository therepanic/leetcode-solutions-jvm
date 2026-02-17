package detectSquares;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {

    private final Map<List<Integer>, Integer> area = new HashMap<>();

    public DetectSquares() {

    }

    public void add(int[] point) {
        List<Integer> key = List.of(point[0], point[1]);
        this.area.put(key, this.area.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int c = 0;
        for (var entry : this.area.entrySet()) {
            List<Integer> key = entry.getKey();
            int dg1 = Math.abs(key.get(0) - point[0]);
            int dg2 =  Math.abs(key.get(1) - point[1]);
            if (dg1 == dg2 && dg1 > 0) {
                int p2 = this.area.getOrDefault(List.of(point[0], key.get(1)), 0);
                int p3 = entry.getValue();
                int p4 = this.area.getOrDefault(List.of(key.get(0), point[1]), 0);
                c += p2 * p3 * p4;
            }
        }
        return c;
    }
}
