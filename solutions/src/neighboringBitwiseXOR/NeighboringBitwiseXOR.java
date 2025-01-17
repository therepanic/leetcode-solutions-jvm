package neighboringBitwiseXOR;

public class NeighboringBitwiseXOR {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for (int num : derived) {
            sum += num;
        }
        return sum % 2 == 0;
    }
}
