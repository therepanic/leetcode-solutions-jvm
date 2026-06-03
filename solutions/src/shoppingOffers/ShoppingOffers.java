package shoppingOffers;

import java.util.*;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<Integer> curSum = new ArrayList<>();
        for (int i = 0; i < price.size(); i++) {
            curSum.add(0);
        }
        return helper(new HashMap<>(), curSum, price, special, needs);
    }

    public int helper(Map<List<Integer>, Integer> cached, List<Integer> curSum,
                       List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (cached.containsKey(curSum)) {
            return cached.get(curSum);
        }
        int min = 0;
        for (int i = 0; i < price.size(); i++) {
            min += (needs.get(i) - curSum.get(i)) * price.get(i);
        }
        for (int i = 0; i < special.size(); i++) {
            boolean ok = true;
            for (int j = 0; j < special.get(i).size() - 1; j++) {
                if (special.get(i).get(j) + curSum.get(j) > needs.get(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                List<Integer> curSumNew = new ArrayList<>(curSum);
                for (int j = 0; j < special.get(i).size() - 1; j++) {
                    curSumNew.set(j, curSumNew.get(j) + special.get(i).get(j));
                }
                min = Math.min(min, special.get(i).getLast() + helper(cached, curSumNew, price, special, needs));
            }
        }
        cached.put(curSum, min);
        return min;
    }
}
