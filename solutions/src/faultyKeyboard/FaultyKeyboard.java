package faultyKeyboard;

public class FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'i') {
                sb = sb.reverse();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
