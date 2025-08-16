package stringCompressionIII;

public class StringCompressionIII {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        Character lastChar = null;
        int c = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (lastChar == null) {
                lastChar = ch;
                c++;
            } else if (lastChar != ch || c == 9) {
                sb.append(c).append(lastChar);
                lastChar = ch;
                c = 1;
            } else {
                c++;
            }
        }
        sb.append(c).append(lastChar);
        return sb.toString();
    }
}
