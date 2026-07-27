package numberOfUniqueXORTripletsI;

public class NumberOfUniqueXORTripletsI {
    public int uniqueXorTriplets(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int s = 0;
        for (int v : nums) {
            s |= v;
        }
        return s + 1;
    }
}
