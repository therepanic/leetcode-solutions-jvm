package largestEvenNumber;

public class LargestEvenNumber {
    public String largestEven(String s) {
        int it = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                break;
            }
            it = i;
        }
        return s.substring(0, it);
    }
}
