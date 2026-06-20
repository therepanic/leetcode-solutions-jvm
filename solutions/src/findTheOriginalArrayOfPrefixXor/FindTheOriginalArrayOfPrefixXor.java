package findTheOriginalArrayOfPrefixXor;

public class FindTheOriginalArrayOfPrefixXor {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        int v = pref[0];
        ans[0] = v;
        for (int i = 1; i < pref.length; i++) {
            ans[i] = v ^ pref[i];
            v ^= v ^ pref[i];
        }
        return ans;
    }
}
