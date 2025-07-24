package smallestValueOfTheRearrangedNumber;

import java.util.*;

public class SmallestValueOfTheRearrangedNumber {
    public static long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        if (num < 0) {
            sb.deleteCharAt(0);
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < sb.length(); i++) {
                values.add(Character.digit(sb.charAt(i), 10));
            }
            values.sort(Comparator.reverseOrder());
            StringBuilder ans = new StringBuilder(values.size() + 1);
            ans.append('-');
            for (int val : values) {
                ans.append(val);
            }
            return Long.parseLong(ans.toString());
        } else {
            int minVal = Integer.MAX_VALUE;
            int id = -1;
            for (int i = 0; i < sb.length(); i++) {
                int val = Character.digit(sb.charAt(i), 10);
                if (val != 0 && val < minVal) {
                    minVal = val;
                    id = i;
                }
            }
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < sb.length(); i++) {
                if (i == id) continue;
                values.add(Character.digit(sb.charAt(i), 10));
            }
            Collections.sort(values);
            StringBuilder answer = new StringBuilder(sb.length());
            answer.append(minVal);
            for (int val : values) {
                answer.append(val);
            }
            return Long.parseLong(answer.toString());
        }
    }
}
