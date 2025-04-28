package smallestPalindromicRearrangementI;

public class SmallestPalindromicRearrangementI {
    public String smallestPalindrome(String s) {
        if (s.length() == 1 || s.length() == 2) {
            return s;
        }
        StringBuilder sb1 = new StringBuilder(s.substring(0, s.length() / 2).chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString());
        StringBuilder sb2 = new StringBuilder(sb1);
        sb2.reverse();
        if (s.length() % 2 != 0) {
            sb1.append(s.charAt(s.length() / 2));
        }
        return sb1.append(sb2).toString();
    }
}
