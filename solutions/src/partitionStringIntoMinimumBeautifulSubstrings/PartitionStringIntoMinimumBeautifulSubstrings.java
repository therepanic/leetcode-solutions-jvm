package partitionStringIntoMinimumBeautifulSubstrings;

import java.util.HashSet;
import java.util.Set;

public class PartitionStringIntoMinimumBeautifulSubstrings {
    public int minimumBeautifulSubstrings(String s) {
        Set<String> nums = new HashSet<>();
        int max = (int) Math.pow(2, s.length()) - 1;
        for (int i = 0; max >= (int) Math.pow(5, i); i++) {
            nums.add(Integer.toBinaryString((int) Math.pow(5, i)));
        }
        int answer = dfs(s, nums);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int dfs(String s, Set<String> nums) {
        if (s.isEmpty()) return 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (nums.contains(s.substring(0, i + 1))) {
                int val = dfs(s.substring(i + 1), nums);
                if (val != Integer.MAX_VALUE) {
                    answer = Math.min(answer, 1 + val);
                }
            }
        }
        return answer;
    }
}
