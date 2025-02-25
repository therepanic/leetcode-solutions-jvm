package countNumbersWithUniqueDigits;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNumbersWithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return helper(0, n, new boolean[10], new HashMap<>());
    }

    private static int helper(int c, int n, boolean[] checked, Map<String, Integer> checkedMap) {
        if (c == n) {
            return 1;
        }
        String key = Arrays.toString(checked) + "|" + c;
        if (checkedMap.containsKey(key)) return checkedMap.get(key);
        int count = 1;
        for (int i = 0; i < 10; i++) {
            if (!checked[i] && (c != 0 || i != 0)) {
                checked[i] = true;
                count += helper(c + 1, n, checked, checkedMap);
                checked[i] = false;
            }
        }
        checkedMap.put(key, count);
        return count;
    }
}
