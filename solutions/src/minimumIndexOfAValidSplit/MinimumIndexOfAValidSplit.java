package minimumIndexOfAValidSplit;

import java.util.List;

public class MinimumIndexOfAValidSplit {
    public int minimumIndex(List<Integer> nums) {
        int candidate = find(nums);
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) totalCount++;
        }
        int countPref = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate) {
                countPref++;
            }
            if (countPref > (i + 1) / 2 && (totalCount - countPref) > (nums.size() - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }
    public int find(List<Integer> nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else {
                count += (num == candidate) ? 1 : -1;
            }
        }
        return candidate;
    }
}
