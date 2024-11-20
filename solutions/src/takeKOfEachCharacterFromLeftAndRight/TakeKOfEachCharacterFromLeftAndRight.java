package takeKOfEachCharacterFromLeftAndRight;

public class TakeKOfEachCharacterFromLeftAndRight {
    public static int takeCharacters(String s, int k) {
        int[] chars = new int[3];
        char[] sChars = s.toCharArray();

        for (char c : sChars) {
            chars[c - 'a']++;
        }

        if (chars[0] < k || chars[1] < k || chars[2] < k) {
            return -1;
        }

        int l = 0;
        int steps = Integer.MAX_VALUE;

        for (int r = 0; r < sChars.length; r++) {
            chars[sChars[r] - 'a']--;

            while (l < sChars.length && (chars[0] < k || chars[1] < k || chars[2] < k)) {
                chars[sChars[l] - 'a']++;
                l++;
            }

            steps = Math.min(steps, sChars.length - (r - l + 1));
        }

        return steps;
    }
}
