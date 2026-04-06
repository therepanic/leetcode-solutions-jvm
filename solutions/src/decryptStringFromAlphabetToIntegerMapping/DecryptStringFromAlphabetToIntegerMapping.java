package decryptStringFromAlphabetToIntegerMapping;

public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder decoded = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i + 2 < chars.length && chars[i + 2] == '#') {
                int id = ((int) chars[i] - '0') * 10 + ((int) chars[i + 1] - '0');
                decoded.append((char) ('a' + id - 1));
                i += 2;
            } else {
                int id = chars[i] - '0';
                decoded.append((char) ('a' + id - 1));
            }
        }
        return decoded.toString();
    }
}
