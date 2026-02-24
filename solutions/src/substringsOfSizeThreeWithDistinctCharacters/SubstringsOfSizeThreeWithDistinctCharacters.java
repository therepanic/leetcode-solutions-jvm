package substringsOfSizeThreeWithDistinctCharacters;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int l = 0;
        int res = 0;
        char[] sChars = s.toCharArray();
        for (int r = 2; r < s.length(); r++, l++) {
            char a = sChars[l];
            char b = sChars[l + 1];
            char c = sChars[l + 2];
            if (a != b && a != c && b != c) {
                res++;
            }
        }
        return res;
    }
}
