package hashDividedString;

public class HashDividedString {
    public String stringHash(String s, int k) {
        StringBuilder hash = new StringBuilder();
        for (int i = k; i <= s.length(); i += k) {
            int sum = 0;
            for (int j = i - k; j < i; j++) {
                sum += s.charAt(j) - 'a';
            }
            hash.append((char) ((sum % 26) + 'a'));
        }
        return hash.toString();
    }
}
