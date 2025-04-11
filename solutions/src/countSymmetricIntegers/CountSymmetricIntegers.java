package countSymmetricIntegers;

public class CountSymmetricIntegers {
    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int num = low; num <= high; num++) {
            String numStr = String.valueOf(num);
            if (numStr.length() % 2 != 0) {
                continue;
            }
            int first = 0;
            int second = 0;
            for (int i = 0; i < numStr.length() / 2; i++) {
                first += numStr.charAt(i) - '0';
            }
            for (int i = numStr.length() / 2; i < numStr.length(); i++) {
                second += numStr.charAt(i) - '0';
            }
            if (first == second) {
                count++;
            }
        }
        return count;
    }
}
