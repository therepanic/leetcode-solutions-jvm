package filterRestaurantsByVeganFriendlyPriceAndDistance;

import java.util.*;

public class FilterRestaurantsByVeganFriendlyPriceAndDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Map<Integer, int[]> restMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if ((restaurant[2] == 1 && veganFriendly == 1 || veganFriendly == 0) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                answer.add(restaurant[0]);
                restMap.put(restaurant[0], restaurant);
            }
        }
        Collections.sort(answer, (p1, p2) -> {
            if (restMap.get(p1)[1] == restMap.get(p2)[1]) {
                return Integer.compare(restMap.get(p2)[0], restMap.get(p1)[0]);
            } else {
                return Integer.compare(restMap.get(p2)[1], restMap.get(p1)[1]);
            }
        });
        return answer;
    }
}
