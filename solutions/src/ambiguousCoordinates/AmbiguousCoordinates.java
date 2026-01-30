package ambiguousCoordinates;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

    public void helper(int it, StringBuilder cur, String own, List<String> answer, boolean last, boolean point, StringBuilder first) {
        if (it == own.length()) {
            return;
        }
        cur.append(own.charAt(it));
        for (int i = it + 1; i < own.length(); i++) {
            if (!last && (cur.length() == 1 || cur.charAt(0) != '0' || (point && cur.charAt(1) == '.'))
                    && (!point || cur.charAt(cur.length() - 1) != '0')) {
                helper(i, new StringBuilder(), own, answer, true, false, new StringBuilder(cur));
            }
            if (!point) {
                helper(i, new StringBuilder(cur).append("."), own, answer, last, true, first);
            }
            cur.append(own.charAt(i));
        }
        if ((!point && cur.length() > 1 && cur.charAt(0) == '0') ||
                (point && cur.charAt(cur.length() - 1) == '0') ||
                (point && cur.charAt(0) == '0' && cur.charAt(1) != '.')) {
            return;
        }
        if (last && cur.length() + first.length() >= own.length()) {
            answer.add("(" + first + ", " + cur + ")");
        }
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> answer = new ArrayList<>();
        helper(0, new StringBuilder(), s.substring(1, s.length() - 1), answer, false, false, null);
        return answer;
    }
}
