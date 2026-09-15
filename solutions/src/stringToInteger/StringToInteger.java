package stringToInteger;

public class StringToInteger {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int it = 0;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                it++;
            } else {
                break;
            }
        }
        int sign;
        if (it < chars.length && chars[it] == '-') {
            sign = -1;
            it++;
        } else if (it < chars.length && chars[it] == '+'){
            sign = 1;
            it++;
        } else {
            sign = 1;
        }
        for (int i = it; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                break;
            } else {
                int dig = chars[i] - '0';
                long a = ((long) ans * 10 + dig) * sign;
                if (a <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (a >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else {
                    ans = ans * 10 + dig;
                }
            }
        }
        return ans * sign;
    }
}
