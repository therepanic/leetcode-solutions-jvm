package shiftingLettersII;

public class ShiftingLettersII {
    public static String shiftingLetters(String s, int[][] shifts) {
        char[] sChars = s.toCharArray();

        int[] counts = new int[sChars.length];

        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                counts[shift[0]]++;
                if (counts[shift[0]] > 25) {
                    counts[shift[0]] = 0;
                }
                if (shift[1] + 1 < counts.length) {
                    counts[shift[1] + 1]--;

                    if (counts[shift[1] + 1] < 0) {
                        counts[shift[1] + 1] = 25;
                    }
                }
            } else {
                counts[shift[0]]--;
                if (counts[shift[0]] < 0) {
                    counts[shift[0]] = 25;
                }
                if (shift[1] + 1 < counts.length) {
                    counts[shift[1] + 1]++;

                    if (counts[shift[1] + 1] > 25) {
                        counts[shift[1] + 1] = 0;
                    }
                }
            }
        }

        int[] arr = new int[sChars.length];
        arr[0] = counts[0];

        for (int i = 1; i < sChars.length; i++) {
            arr[i] = arr[i - 1] + counts[i];
        }


        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];

            int adder = (c - 'a' + arr[i]) % 26;

            sChars[i] = (char) (adder + 'a');
        }

        return String.valueOf(sChars);
    }
}
