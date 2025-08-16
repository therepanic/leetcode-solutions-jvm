package lexicographicallySmallestStringAfterSubstringOperation;

public class LexicographicallySmallestStringAfterSubstringOperation {

    public String smallestString(String s) {
        char[] sChars = s.toCharArray();
        boolean act = false;
        for (int r = 0; r < sChars.length; r++) {
            char ch =  sChars[r];
            if (ch == 'a' && act) {
                break;
            } else if (ch == 'a') {
                continue;
            }
            act = true;
            int v = ch - 'a' - 1;
            sChars[r] = (char) (v + 'a');
        }
        if (!act) {
            sChars[sChars.length - 1] = 'z';
        }
        return String.valueOf(sChars);
    }
}
