package findTheMinimumAmountOfTimeToBrewPotions;

public class FindTheMinimumAmountOfTimeToBrewPotions {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[j + 1] = Math.max(pref[j], pref[j + 1]) + (long) skill[j] * mana[i];
            }
            for (int j = n - 1; j > 0; j--) {
                pref[j] = pref[j + 1] - (long) skill[j] * mana[i];
            }
        }
        return pref[n];
    }
}
