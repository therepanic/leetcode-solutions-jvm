package friendsOfAppropriateAges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAges {
    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);

        int numCount = 0;

        Map<Integer, Integer> multip = new HashMap<>();

        for (int i = ages.length - 1; i >= 0; i--) {
            if (ages[i] * 0.5 + 7 < ages[i]) {
                numCount += multip.getOrDefault(ages[i], 0);
                multip.put(ages[i], multip.getOrDefault(ages[i], 0) + 1);
            }

            int l = 0;
            int r = i - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (ages[mid] <= 0.5 * ages[i] + 7) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            numCount += i - l;
        }

        return numCount;
    }
}
