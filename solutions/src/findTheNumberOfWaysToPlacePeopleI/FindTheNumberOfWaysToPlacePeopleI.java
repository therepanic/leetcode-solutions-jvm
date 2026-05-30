package findTheNumberOfWaysToPlacePeopleI;

import java.util.Arrays;

public class FindTheNumberOfWaysToPlacePeopleI {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p1[0], p2[0]);
            } else {
                return Integer.compare(p2[1], p1[1]);
            }
        });
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x = Integer.MAX_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] <= points[j][0] && points[j][0] < x) {
                    x = points[j][0];
                    ans++;
                }
            }
        }
        return ans;
    }
}
