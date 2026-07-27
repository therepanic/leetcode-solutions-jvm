package largestIntegerWithGivenDigitSum;

public class LargestIntegerWithGivenDigitSum {
    public int largestInteger(int n, int s) {
        int a = 0;
        int copyN = n;
        int copyS = s;
        int sum = 0;
        while (s != 0 && copyN != 0) {
            int v = Math.min(9, s);
            s -= v;
            a *= 10;
            a += v;
            sum += v;
            copyN--;
        }
        if (sum != copyS) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(a + "");
        while (sb.length() < n) {
            sb.append("0");
        }
        return Integer.parseInt(sb.toString());
    }
}
