package clearDigits;

public class ClearDigits {
    public String clearDigits(String s) {
        char[] sChars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : sChars) {
            if (Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
