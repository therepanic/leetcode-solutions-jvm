package reverseDegreeOfAString;

public class ReverseDegreeOfAString {
    public int reverseDegree(String s) {
        int[] alpha = new int[26];
        int c = 26;
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = c;
            c--;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int it = s.charAt(i) - 'a';
            sum += alpha[it] * (i + 1);
        }
        return sum;
    }
}
