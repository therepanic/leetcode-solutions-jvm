package anglesOfATriangle;

import java.util.Arrays;

public class AnglesOfATriangle {
    public double[] internalAngles(int[] sides) {
        int a = sides[0], b = sides[1], c = sides[2];
        if (a + b <= c || b + c <= a || a + c <= b) {
            return new double[0];
        }
        double[] degrees = new double[] {calculateAngle(b, c, a), calculateAngle(a, c, b), calculateAngle(a, b, c)};
        Arrays.sort(degrees);
        return degrees;
    }

    public static double calculateAngle(double a, double b, double c) {
        double cosC = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
        double angleRadians = Math.acos(cosC);
        return Math.toDegrees(angleRadians);
    }
}
