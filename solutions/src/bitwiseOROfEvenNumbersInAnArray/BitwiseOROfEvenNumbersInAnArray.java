package bitwiseOROfEvenNumbersInAnArray;

public class BitwiseOROfEvenNumbersInAnArray {
    public int evenNumberBitwiseORs(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                a |= nums[i];
            }
        }
        return a;
    }
}
