package countAlmostEqualPairsI;

import java.util.*;

public class CountAlmostEqualPairsI {
    public int countPairs(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                StringBuilder check = new StringBuilder(String.valueOf(nums[j]));
                if (nums[i] == nums[j]) {
                    answer++;
                    continue;
                }
                boolean matched = false;
                for (int k = 0; k < check.length() && !matched; k++) {
                    for (int l = k + 1; l < check.length(); l++) {
                        char copy = check.charAt(k);
                        check.setCharAt(k, check.charAt(l));
                        check.setCharAt(l, copy);
                        if (Integer.parseInt(check.toString()) == nums[i]) {
                            answer++;
                            matched = true;
                        }
                        copy = check.charAt(k);
                        check.setCharAt(k, check.charAt(l));
                        check.setCharAt(l, copy);
                        if (matched) break;
                    }
                }
            }
        }
        return answer;
    }
}
