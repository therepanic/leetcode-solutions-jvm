package longestChunkedPalindromeDecomposition;

public class LongestChunkedPalindromeDecomposition {
    public static int longestDecomposition(String text) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();

        char[] textChars = text.toCharArray();

        int count = 0;

        for (int i = 0; i < textChars.length / 2; i++) {
            first.append(textChars[i]);
            second.insert(0, textChars[textChars.length - i - 1]);

            if (first.compareTo(second) == 0) {
                count+=2;
                first.setLength(0);
                second.setLength(0);
            }
        }


        if (!first.isEmpty() || textChars.length % 2 != 0) {
            count += 1;
        }
        return count;
    }
}
