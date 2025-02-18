package wateringPlantsII;

public class WateringPlantsII {
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int curCapA = capacityA;
        int curCapB = capacityB;

        int l = 0;
        int r = plants.length - 1;

        int c = 0;
        while (l <= r) {
            if (l == r && Math.max(curCapA, curCapB) - plants[l] < 0) {
                c++;
                break;
            } else if (l == r) {
                break;
            }
            if (curCapA - plants[l] < 0) {
                c++;
                curCapA = capacityA;
            }
            curCapA -= plants[l];
            l++;
            if (curCapB - plants[r] < 0) {
                c++;
                curCapB = capacityB;
            }
            curCapB -= plants[r];
            r--;
        }
        return c;
    }
}
