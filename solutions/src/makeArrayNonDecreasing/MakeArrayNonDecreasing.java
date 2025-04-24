package makeArrayNonDecreasing;

public class MakeArrayNonDecreasing {
    public int maximumPossibleSize(int[] nums) {
        int prev = -1;
        int answer = 0;
        for (int num : nums) {
            if (num >= prev) {
                prev = num;
                answer++;
            }
        }
        return answer;
    }
}
