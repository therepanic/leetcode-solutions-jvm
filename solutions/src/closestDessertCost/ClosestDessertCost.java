package closestDessertCost;

public class ClosestDessertCost {
    public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int[] best = new int[]{baseCosts[0]};
        for (int cost : baseCosts) {
            bypass(toppingCosts, 0, cost, best, target);
        }
        return best[0];
    }

    public static void bypass(int[] toppingCosts, int it, int num, int[] best, int target) {
        if(Math.abs(num - target) < Math.abs(best[0] - target) || Math.abs(num - target) == Math.abs(best[0] - target) && num < best[0]) {
            best[0] = num;
        }

        if (it == toppingCosts.length) return;

        bypass(toppingCosts, it + 1, num, best, target);
        bypass(toppingCosts, it + 1, num + toppingCosts[it], best, target);
        bypass(toppingCosts, it + 1, num + toppingCosts[it] * 2, best, target);
    }
}
