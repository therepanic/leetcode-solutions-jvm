package bullsAndCows;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int b = 0;
        int cows = 0;
        int[] c = new int[10];
        char[] secrets = secret.toCharArray();
        char[] guesss = guess.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            if (secrets[i] != guesss[i]) {
                c[secrets[i] - '0']++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secrets[i] != guesss[i]) {
                if (c[guesss[i] - '0'] > 0) {
                    cows++;
                    c[guesss[i] - '0']--;
                }
            } else {
                b++;
            }
        }
        return b + "A" + cows + "B";
    }
}
