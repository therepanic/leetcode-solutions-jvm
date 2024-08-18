package palindromicSubstrings;

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        char[] sChars = s.toCharArray();

        int count = 0;
        for (int i = 0; i < sChars.length; i++) {
            count += getPalindromesCount(sChars, i, i);
            count += getPalindromesCount(sChars, i, i + 1);
        }

        return count;
    }

    public static int getPalindromesCount(char[] sChars, int l, int r) {
        int count = 0;

        while (l >= 0 && r < sChars.length) {
            if (sChars[l] != sChars[r]) {
                break;
            }

            count++;

            l--;
            r++;
        }

        return count;
    }
}
