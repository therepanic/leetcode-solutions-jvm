package minimumOperationsToMakeBinaryArrayElementsEqualToOneII;

public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneII {
    public int minOperations(int[] nums) {
        int c = 0;
        for (int v : nums) {
            if ((v + c) % 2 == 0) {
                c++;
            }
        }
        return c;
    }
}
