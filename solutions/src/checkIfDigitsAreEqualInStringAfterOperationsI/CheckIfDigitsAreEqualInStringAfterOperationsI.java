package checkIfDigitsAreEqualInStringAfterOperationsI;

public class CheckIfDigitsAreEqualInStringAfterOperationsI {
    public boolean hasSameDigits(String s) {
        StringBuilder cur = new StringBuilder(s);
        StringBuilder newS = new StringBuilder();
        while (cur.length() != 2) {
            for (int i = 0; i < cur.length() - 1; i++) {
                int a = Character.digit(cur.charAt(i), 10);
                int b = Character.digit(cur.charAt(i + 1), 10);
                newS.append((a + b) % 10);
            }
            cur = new StringBuilder(newS);
            newS.setLength(0);
        }
        return cur.charAt(0) == cur.charAt(1);
    }
}
