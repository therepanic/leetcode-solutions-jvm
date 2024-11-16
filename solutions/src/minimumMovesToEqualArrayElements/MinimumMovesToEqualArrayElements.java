package minimumMovesToEqualArrayElements;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int result = 0;
        for (int num : nums) {
            minNum = Math.min(minNum, num);
        }

        for (int num : nums) {
            result += num - minNum;
        }

        return result;
    }
}
