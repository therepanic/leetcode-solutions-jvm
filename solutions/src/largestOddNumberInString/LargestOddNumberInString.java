package largestOddNumberInString;

public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        for (; i >= 0; i--) {
            int a = num.charAt(i) - '0';
            if (a % 2 != 0) {
                break;
            }
        }
        return num.substring(0, i + 1);
    }
}
