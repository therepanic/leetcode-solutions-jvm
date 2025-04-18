package findTheScoreOfAllPrefixesOfAnArray;

public class FindTheScoreOfAllPrefixesOfAnArray {
    public long[] findPrefixScore(int[] nums) {
        long[] answer = new long[nums.length];
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], nums[i]);
        }
        answer[0] = prefixSum[0] + nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer[i] = prefixSum[i] + nums[i] + answer[i - 1];
        }
        return answer;
    }
}
