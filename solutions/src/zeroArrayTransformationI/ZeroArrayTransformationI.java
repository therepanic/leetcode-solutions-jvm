package zeroArrayTransformationI;

public class ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] pref = new int[nums.length];

        for (int[] query : queries) {
            pref[query[0]]++;

            if (query[1] + 1 < pref.length) {
                pref[query[1] + 1]--;
            }
        }

        for (int i = 1; i < pref.length; i++) {
            pref[i] += pref[i - 1];
        }

        for (int i = 0; i < pref.length; i++) {
            if (pref[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
