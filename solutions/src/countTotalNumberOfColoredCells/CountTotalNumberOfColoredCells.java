package countTotalNumberOfColoredCells;

public class CountTotalNumberOfColoredCells {
    public static long coloredCells(int n) {
        return (long) Math.pow(n, 2) + (long) (Math.pow(n - 1, 2));
    }
}
