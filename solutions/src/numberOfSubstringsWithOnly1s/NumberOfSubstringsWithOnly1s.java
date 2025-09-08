package numberOfSubstringsWithOnly1s;

public class NumberOfSubstringsWithOnly1s {
    public int numSub(String s) {
        long sum = 0;
        long perm = 0;
        int MOD = 1000000007;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                perm++;
                sum = (sum + perm) % MOD;
            } else {
                perm = 0;
            }
        }
        return (int) (sum % MOD);
    }
}
