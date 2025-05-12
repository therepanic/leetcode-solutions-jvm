package finding3DigitEvenNumbers;

import java.util.*;

public class Finding3DigitEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> available = new HashSet<>();
        int[] has = new int[10];
        for (int digit : digits) {
            has[digit]++;
        }
        for (int i = 1; i <= 9; i++) {
            if (has[i] == 0) {
                continue;
            }
            has[i]--;
            for (int j = 0; j <= 9; j++) {
                if (has[j] == 0) {
                    continue;
                }
                has[j]--;
                for (int k = 0; k <= 8; k+=2) {
                    if (has[k] == 0) {
                        continue;
                    }
                    int num = i * 100 + j * 10 + k;
                    available.add(num);
                }
                has[j]++;
            }
            has[i]++;
        }
        int[] ans = new int[available.size()];
        int it = 0;
        for (int val : available) {
            ans[it] = val;
            it++;
        }
        Arrays.sort(ans);
        return ans;
    }
}
