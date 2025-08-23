package countNumberOfHomogenousSubstrings;

public class CountNumberOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        long answer = 0;
        int l = 0;
        char[] sChars = s.toCharArray();
        for (int r = 0; r < sChars.length; r++) {
            if (sChars[r] != sChars[l]) {
                int diff = r - l;
                answer += ((long) diff * (diff + 1)) / 2;
                l = r;
            }
        }
        int diff = sChars.length - l;
        answer += ((long) diff * (diff + 1)) / 2;
        return (int) (answer % 1000000007);
    }
}
