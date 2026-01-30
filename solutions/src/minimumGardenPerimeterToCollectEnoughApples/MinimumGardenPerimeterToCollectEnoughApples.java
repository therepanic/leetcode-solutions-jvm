package minimumGardenPerimeterToCollectEnoughApples;

public class MinimumGardenPerimeterToCollectEnoughApples {
    public long minimumPerimeter(long neededApples) {
        int minPerimeter = Integer.MAX_VALUE;
        int start = 0;
        int end = 100000;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long apples = (long) 2 * mid * (mid + 1L) * (2L * mid + 1);
            if (apples == neededApples) {
                return mid * 8L;
            } else if (apples > neededApples) {
                minPerimeter = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minPerimeter * 8L;
    }
}
