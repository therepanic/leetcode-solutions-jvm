package rearrangeStringToAvoidCharacterPair;

public class RearrangeStringToAvoidCharacterPair {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == y) {
                sb.append(y);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != y) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
