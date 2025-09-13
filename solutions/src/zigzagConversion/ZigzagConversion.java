package zigzagConversion;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (s == null) return null;
        if (numRows <= 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        int cur = 0;
        int dir = 1;
        for (char c : s.toCharArray()) {
            rows[cur].append(c);
            if (cur == 0) dir = 1;
            else if (cur == numRows - 1) dir = -1;
            cur += dir;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : rows) {
            ans.append(sb);
        }
        return ans.toString();
    }
}
