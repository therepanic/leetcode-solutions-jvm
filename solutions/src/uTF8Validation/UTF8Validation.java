package uTF8Validation;

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int c = 0;
        for (int d : data) {
            String str = Integer.toBinaryString(d);
            if (str.length() < 8) {
                str = "0".repeat(8 - str.length()) + str;
            }
            if (c != 0 && !str.startsWith("10")) {
                return false;
            } else if (c != 0 && str.startsWith("10")) {
                c--;
                continue;
            }
            if (str.startsWith("11110")) {
                c = 3;
                continue;
            } else if (str.startsWith("1110")) {
                c = 2;
                continue;
            } else if (str.startsWith("110")) {
                c = 1;
                continue;
            } else if (str.startsWith("0")) {
                c = 0;
                continue;
            }
            return false;
        }
        return c == 0;
    }
}
