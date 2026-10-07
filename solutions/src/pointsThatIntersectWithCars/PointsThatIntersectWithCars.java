package pointsThatIntersectWithCars;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        int ans = 0;
        Collections.sort(nums, Comparator.comparingInt(p -> p.get(0)));
        int start = nums.get(0).get(0);
        int end = nums.get(0).get(1);
        for (int i = 1; i < nums.size(); i++) {
            if (end >= nums.get(i).get(0)) {
                end = Math.max(end, nums.get(i).get(1));
            } else {
                ans += end - start + 1;
                start = nums.get(i).get(0);
                end = nums.get(i).get(1);
            }
        }
        return ans + end - start + 1;
    }
}
