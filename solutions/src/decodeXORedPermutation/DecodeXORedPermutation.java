package decodeXORedPermutation;

public class DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int x = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            x ^= encoded[i];
        }
        int s = 0;
        for (int i = 1; i <= encoded.length + 1; i++) {
            s ^= i;
        }
        s ^= x;
        int[] ans = new int[encoded.length + 1];
        ans[0] = s;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
