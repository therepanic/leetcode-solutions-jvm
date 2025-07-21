package minimumOperationsToMakeAllArrayElementsEqual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumOperationsToMakeAllArrayElementsEqual {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefSum[i + 1] = prefSum[i] + nums[i];
        }
        List<Long> answer = new ArrayList<>();
        for (int query : queries) {
            int idx = Arrays.binarySearch(nums, query);
            if (idx < 0) {
                idx = -idx - 1;
            }
            long smaller = 0;
            int smallerCount;
            long bigger = 0;
            int biggerCount;
            smaller += prefSum[idx];
            smallerCount = idx;
            bigger += prefSum[n] - prefSum[idx];
            biggerCount = n - idx;
            answer.add((Math.abs(smaller - (long) query * smallerCount)) + (Math.abs(bigger - (long) query * biggerCount)));
        }
        return answer;
    }
}
