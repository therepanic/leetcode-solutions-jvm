package findThePunishmentNumberOfAnInteger;

import java.util.ArrayList;
import java.util.List;

public class FindThePunishmentNumberOfAnInteger {
    public static int punishmentNumber(int n) {
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            int square = i * i;
            if (decomp(String.valueOf(square), 0, 0, i, new ArrayList<>())) {
                sum += square;
            }
        }
        return sum;
    }

    public static boolean decomp(String square, int it, int sum, int needSum, List<String> parts) {
        if (it == square.length()) {
            return sum == needSum && !parts.isEmpty();
        }
        int curPref = 0;
        for (int i = it; i < square.length(); i++) {
            curPref = curPref * 10 + Character.getNumericValue(square.charAt(i));
            if (sum + curPref > needSum) break;
            parts.add(String.valueOf(curPref));
            if (decomp(square, i + 1, sum + curPref, needSum, parts)) return true;
            parts.removeLast();
        }
        return false;
    }
}
