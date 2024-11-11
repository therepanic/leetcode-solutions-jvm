package reorderedPowerOf2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 1_000_000_000; i *= 2) {
            nums.add(i);
        }

        char[] nChars = String.valueOf(n).toCharArray();
        Arrays.sort(nChars);

        for (int i = nums.size() - 1; i >= 0; i--) {
            char[] num = String.valueOf(nums.get(i)).toCharArray();
            Arrays.sort(num);

            if (Arrays.equals(nChars, num)) {
                return true;
            }
        }

        return false;
    }
}
