package strongPasswordCheckerII;

public class StrongPasswordCheckerII {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        int low = 0;
        int high = 0;
        int dig = 0;
        int spec = 0;
        char[] pass = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            if (i < password.length() - 1 && pass[i] == pass[i + 1]) {
                return false;
            }
            if (Character.isDigit(pass[i])) {
                dig++;
            } else if (Character.isLowerCase(pass[i])) {
                low++;
            } else if (Character.isUpperCase(pass[i])) {
                high++;
            } else if (!Character.isAlphabetic(pass[i])) {
                spec++;
            }
        }
        return low != 0 && high != 0 && dig != 0 && spec != 0;
    }
}
