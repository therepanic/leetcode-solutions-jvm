package minimumTimeToRevertWordToInitialStateI;

public class MinimumTimeToRevertWordToInitialStateI {
    public int minimumTimeToInitialState(String word, int k) {
        char[] wordChars = word.toCharArray();
        String copy = word;
        int c = 0;
        do {
            c++;
            copy = copy.substring(k) + "*".repeat(k);
        } while (!check(wordChars, copy));
        return c;
    }

    public boolean check(char[] wordChars, String copy) {
        for (int i = 0; i < wordChars.length; i++) {
            if (copy.charAt(i) == '*') {
                return true;
            } else if (copy.charAt(i) != wordChars[i]) {
                return false;
            }
        }
        return true;
    }
}
