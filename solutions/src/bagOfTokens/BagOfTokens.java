package bagOfTokens;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int l = 0;
        int r = tokens.length - 1;
        while (l <= r) {
            if (power < tokens[l]) {
                if (l != r && score >= 1) {
                    score--;
                    power += tokens[r];
                    r--;
                } else {
                    break;
                }
            } else {
                power -= tokens[l];
                score++;
                l++;
            }
        }
        return score;
    }
}
