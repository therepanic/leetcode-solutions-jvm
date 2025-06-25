package designAFoodRatingSystem;

import java.util.*;

public class FoodRatings {

    static class Tuple<T, K> {

        public Tuple(T first, K second) {
            this.first = first;
            this.second = second;
        }

        T first;
        K second;
    }

    private final Map<String, Integer> bannedFood;
    private final Map<String, Tuple<String, Integer>> foodCuisines = new HashMap<>();
    private final Map<String, PriorityQueue<Tuple<String, Integer>>> cuisinesRating;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.bannedFood = new HashMap<>();
        this.cuisinesRating = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            this.foodCuisines.put(foods[i], new Tuple<>(cuisines[i], ratings[i]));
            this.cuisinesRating.computeIfAbsent(cuisines[i], p -> new PriorityQueue<>((p1, p2) -> p1.second.equals(p2.second)
                    ? p1.first.compareTo(p2.first)
                    : Integer.compare(p2.second, p1.second))).add(new Tuple<>(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        var poll = this.foodCuisines.get(food);
        if (poll != null) {
            String key = food + "-" + poll.second;
            this.bannedFood.put(key, this.bannedFood.getOrDefault(key, 0) + 1);
            poll.second = newRating;
            this.cuisinesRating.get(poll.first).add(new Tuple<>(food, newRating));
        }
    }

    public String highestRated(String cuisine) {
        var tuples = this.cuisinesRating.get(cuisine);
        while (!tuples.isEmpty()) {
            var tuple = tuples.peek();
            String key = tuple.first + "-" + tuple.second;
            if (this.bannedFood.containsKey(key)) {
                tuples.poll();
                this.bannedFood.compute(key, (k, v) -> v == 1 ? null : v - 1);
            } else {
                return tuple.first;
            }
        }
        return null;
    }

}
