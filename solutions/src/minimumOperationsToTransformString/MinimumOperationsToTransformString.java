package minimumOperationsToTransformString;

public class MinimumOperationsToTransformString {
    public int minOperations(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 1; i < 26 ; i++) {
            if (counts[i] != 0) {
                return 26 - i;
            }
        }
        return 0;
    }
}
