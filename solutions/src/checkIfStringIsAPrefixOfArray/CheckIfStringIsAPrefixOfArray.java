package checkIfStringIsAPrefixOfArray;

public class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String val : words) {
            sb.append(val);
            if (sb.length() == s.length()) {
                return sb.toString().startsWith(s);
            }
        }
        return false;
    }
}
