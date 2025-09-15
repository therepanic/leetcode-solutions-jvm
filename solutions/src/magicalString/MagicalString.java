package magicalString;

public class MagicalString {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int it = 2;
        while (sb.length() < n) {
            char nextChar = sb.charAt(sb.length() - 1) == '1' ? '2' : '1';
            String str = String.valueOf(nextChar);
            sb.append(str.repeat(Character.digit(sb.charAt(it), 10)));
            it++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
