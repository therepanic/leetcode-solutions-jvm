package boatsToSavePeople;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0;
        int r = people.length - 1;

        int count = 0;
        while (l < r) {
            if (people[r] + people[l] <= limit) {
                l++;
                r--;
                count++;
            } else {
                count++;
                r--;
            }
        }

        return count;
    }
}
