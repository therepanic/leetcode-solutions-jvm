package largestTriangleArea;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        if (n < 3) return 0.0;
        double maxArea = 0.0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = shoelace(points[i], points[j], points[k]);
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public double shoelace(int[] first, int[] second, int[] third) {
        int x1 = first[0], y1 = first[1];
        int x2 = second[0], y2 = second[1];
        int x3 = third[0], y3 = third[1];
        int sumRight = x1 * y2 + x2 * y3 + x3 * y1;
        int sumLeft  = y1 * x2 + y2 * x3 + y3 * x1;
        double area = (double) Math.abs(sumRight - sumLeft) / 2;
        return area;
    }
}
