package minimumMovesToEqualArrayElementsIII;

public class MinimumMovesToEqualArrayElementsIII {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int c = 0;
        for (int num : nums) {
            c += max - num;
        }
        return c;
    }
}
