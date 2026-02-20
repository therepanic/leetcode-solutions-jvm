package arithmeticSubarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        int n = l.length;
        first: for (int i = 0; i < n; i++) {
            int[] values = new int[r[i] - l[i] + 1];
            int it = 0;
            for (int j = l[i]; j <= r[i]; j++, it++) {
                values[it] = nums[j];
            }
            Arrays.sort(values);
            for (int j = 2; j < values.length; j++) {
                if (values[j] - values[j - 1] != values[1] - values[0]) {
                    answer.add(false);
                    continue first;
                }
            }
            answer.add(true);
        }
        return answer;
    }
}
