package shiftingLetters;

public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        long[] count = new long[shifts.length];
        count[count.length - 1] = shifts[shifts.length - 1];

        for (int i = shifts.length - 2; i >= 0; i--) {
            count[i] += count[i + 1] + shifts[i];
        }

        char[] sChars = s.toCharArray();

        for (int i = 0; i < count.length; i++) {
            long curVal = sChars[i] - 'a';

            sChars[i] = (char) (((curVal + count[i]) % 26) + 'a');
        }

        return String.valueOf(sChars);
    }
}
