package minimumElementsToAddToFormAGivenSum;

public class MinimumElementsToAddToFormAGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int v : nums) {
            sum += v;
        }
        long diff = Math.abs(sum - goal);
        int ans = (int) (diff / limit);
        if (diff % limit != 0) {
            ans++;
        }
        return ans;
    }
}
