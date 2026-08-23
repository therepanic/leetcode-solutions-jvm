package checkASCIIPalindromic;

public class CheckASCIIPalindromic {
    public boolean isPalindromic(String s) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            binary.append(String.format("%8s", Integer.toBinaryString(a)).replace(' ', '0'));
        }
        for (int i = 0; i < binary.length() / 2; i++) {
            if (binary.charAt(i) != binary.charAt(binary.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
