package stringCompression;

public class StringCompression {

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        char lastCh = chars[0];
        int count = 1;
        int it = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == lastCh) {
                count++;
            } else {
                if (count > 1) {
                    for (char ch : String.valueOf(count).toCharArray()) {
                        chars[it] = ch;
                        it++;
                    }
                }
                chars[it] = chars[i];
                it++;
                count = 1;
                lastCh = chars[i];
            }
        }
        if (count > 1) {
            for (char ch : String.valueOf(count).toCharArray()) {
                chars[it] = ch;
                it++;
            }
        }
        return it;
    }

}
