package minimumStringLengthAfterBalancedRemovals;

public class MinimumStringLengthAfterBalancedRemovals {
    public int minLengthAfterRemovals(String s) {
        char[] chars = new char[s.length()];
        int top = -1;
        for (char c : s.toCharArray()) {
            if (top >= 0 && c != chars[top]) {
                top--;
            } else {
                chars[++top] = c;
            }
        }
        return top + 1;
    }
}
