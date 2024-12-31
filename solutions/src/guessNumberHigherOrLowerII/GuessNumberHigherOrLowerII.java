package guessNumberHigherOrLowerII;

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
        return bypass(1, n);
    }

    public int bypass(int l, int r) {
        if (l >= r) return 0;
        int minCost = Integer.MAX_VALUE;

        for (int i = l; i <= r; i++) {
            int cost = i + Math.max(bypass(i + 1, r), bypass(l, i - 1));

            minCost = Math.min(cost, minCost);
        }

        return minCost;
    }
}
