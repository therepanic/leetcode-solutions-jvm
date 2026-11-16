package calculateDigitSumOfAString;

public class CalculateDigitSumOfAString {
    public String digitSum(String s, int k) {
        StringBuilder a = new StringBuilder(s);
        while (a.length() > k) {
            int sum = 0;
            StringBuilder c = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                sum += a.charAt(i) - '0';
                if ((i + 1) % k == 0 || i == a.length() - 1) {
                    c.append(sum);
                    sum = 0;
                }
            }
            a = c;
        }
        return a.toString();
    }
}
