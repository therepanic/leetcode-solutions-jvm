package minimumAmountOfTimeToCollectGarbage;

public class MinimumAmountOfTimeToCollectGarbage {
    public int garbageCollection(String[] garbage, int[] travel) {
        boolean m = false;
        boolean p = false;
        boolean g = false;
        int ans = garbage[0].length();
        for (int i = garbage.length - 1; i > 0; i--) {
            m |= garbage[i].contains("M");
            p |= garbage[i].contains("P");
            g |= garbage[i].contains("G");
            ans += travel[i - 1] * ((m ? 1 : 0) + (p ? 1 : 0) + (g ? 1 : 0)) + garbage[i].length();
        }
        return ans;
    }
}
