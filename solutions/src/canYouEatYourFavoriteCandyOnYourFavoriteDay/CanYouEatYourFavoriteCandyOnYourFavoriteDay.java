package canYouEatYourFavoriteCandyOnYourFavoriteDay;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] pref = new long[candiesCount.length];
        pref[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            pref[i] = pref[i - 1] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int type = queries[i][0];
            int day = queries[i][1];
            int cap = queries[i][2];

            long before = (type == 0) ? 0 : pref[type - 1];
            long total = pref[type];

            long minEaten = day + 1;
            long maxEaten = ((long) day + 1) * cap;

            ans[i] = (maxEaten > before) && (minEaten <= total);
        }
        return ans;
    }
}
