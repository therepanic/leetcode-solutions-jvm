package largest3SameDigitNumberInString;

public class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        char[] numChars = num.toCharArray();
        String max = "";
        int l = 0;
        int maxVal = -1;
        int[] alphabet = new int[10];
        int uniq = 0;
        for (int r = 0; r < numChars.length; r++) {
            int key = numChars[r] - '0';
            if (alphabet[key] == 0) uniq++;
            alphabet[key]++;
            while (uniq > 1) {
                key = numChars[l] - '0';
                alphabet[key]--;
                if (alphabet[key] == 0) uniq--;
                l++;
            }
            if (r - l + 1 == 3 && uniq == 1) {
                int val = Character.digit(numChars[r], 10);
                if (maxVal < val) {
                    maxVal = val;
                    max = String.valueOf(maxVal).repeat(3);
                }
            }
        }
        return max;
    }

}
