package countTheNumberOfComputerUnlockingPermutations;

public class CountTheNumberOfComputerUnlockingPermutations {
    public int countPermutations(int[] complexity) {
        long ans = 1;
        int p = 1_000_000_007;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[0] >= complexity[i]) {
                return 0;
            }
            ans = (ans * i) % p;
        }
        return (int) ans;
    }
}
