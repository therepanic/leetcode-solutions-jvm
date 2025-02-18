package wateringPlants;

public class WateringPlants {
    public static int wateringPlants(int[] plants, int capacity) {
        int curCap = capacity;
        int jump = 0;
        for (int i = 0; i < plants.length; i++) {
            if (curCap - plants[i] < 0) {
                curCap = capacity;
                jump += 2 * i;
            }
            curCap -= plants[i];
        }
        jump += plants.length;
        return jump;
    }
}
