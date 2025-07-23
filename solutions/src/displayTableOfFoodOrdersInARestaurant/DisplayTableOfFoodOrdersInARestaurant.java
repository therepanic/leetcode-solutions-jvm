package displayTableOfFoodOrdersInARestaurant;

import java.util.*;

public class DisplayTableOfFoodOrdersInARestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> countMap = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        List<String> food = new ArrayList<>();
        Set<Integer> alreadyNumber = new HashSet<>();
        Set<String> alreadyFood = new HashSet<>();
        for (var entry : orders) {
            var map = countMap.computeIfAbsent(entry.get(1), p -> new HashMap<>());
            map.put(entry.get(2), map.getOrDefault(entry.get(2), 0) + 1);
            if (!alreadyNumber.contains(Integer.parseInt(entry.get(1)))) {
                alreadyNumber.add(Integer.parseInt(entry.get(1)));
                numbers.add(Integer.parseInt(entry.get(1)));
            }
            if (!alreadyFood.contains(entry.get(2))) {
                alreadyFood.add(entry.get(2));
                food.add(entry.get(2));
            }
        }
        Collections.sort(food);
        Collections.sort(numbers);
        List<List<String>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.getFirst().add("Table");
        for (String s : food) {
            answer.getFirst().add(s);
        }
        for (int i = 0; i < numbers.size(); i++) {
            List<String> toAdd = new ArrayList<>();
            String val = String.valueOf(numbers.get(i));
            for (int j = 0; j < answer.getFirst().size(); j++) {
                if (j == 0) {
                    toAdd.add(String.valueOf(val));
                } else {
                    int c = countMap.get(val).getOrDefault(answer.getFirst().get(j), 0);
                    toAdd.add(String.valueOf(c));
                }
            }
            answer.add(toAdd);
        }
        return answer;
    }
}
