package queriesOnNumberOfPointsInsideACircle;

public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] count = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int x = points[j][0];
                int y = points[j][1];
                double distance = Math.sqrt(Math.pow(queries[i][0] - x, 2) + (Math.pow(queries[i][1] - y, 2)));
                if (distance <= queries[i][2]) {
                    count[i]++;
                }
            }
        }
        return count;
    }
}
