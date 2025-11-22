package totalWavinessOfNumbersInRangeI;

public class TotalWavinessOfNumbersInRangeI {
    public int totalWaviness(int num1, int num2) {
        int c = 0;
        for (int i = num1; i <= num2; i++) {
            String a = String.valueOf(i);
            for (int j = 1; j < a.length() - 1; j++) {
                int cur = Character.digit(a.charAt(j), 10);
                int prev = Character.digit(a.charAt(j - 1), 10);
                int next = Character.digit(a.charAt(j + 1), 10);
                if (cur < prev && cur < next || cur > prev && cur > next) {
                    c++;
                }
            }
        }
        return c;
    }
}
