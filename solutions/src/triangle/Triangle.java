package triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> clone = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            clone.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                clone.getLast().add(-1);
            }
        }
        return check(triangle, clone, 0, 0);
    }

    public static int check(List<List<Integer>> triangle, List<List<Integer>> triangleCop, int m, int n) {
        if (triangle.size() <= m || triangle.get(m).size() <= n) return 0;
        if (triangleCop.get(m).get(n) == -1) {
            int result = triangle.get(m).get(n) + (Math.min(check(triangle, triangleCop, m + 1, n), check(triangle, triangleCop, m + 1, n + 1)));
            triangleCop.get(m).set(n, result);
        }
        return triangleCop.get(m).get(n);
    }
}
