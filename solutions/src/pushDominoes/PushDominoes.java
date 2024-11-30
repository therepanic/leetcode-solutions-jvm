package pushDominoes;

public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        char[] dominoesChars = dominoes.toCharArray();
        int[] forces = new int[dominoesChars.length];

        int max = dominoesChars.length;

        int force = 0;
        for (int i = 0; i < dominoesChars.length; i++) {
            if (dominoesChars[i] == 'R') {
                force = max;
            } else if (dominoesChars[i] == 'L') {
                force = 0;
            }

            forces[i] = force;
            if (force == 0) continue;
            force--;
        }

        force = 0;
        for (int i = dominoesChars.length - 1; i >= 0; i--) {
            if (dominoesChars[i] == 'L') {
                force = max;
            } else if (dominoesChars[i] == 'R') {
                force = 0;
            }

            forces[i] -= force;
            if (force == 0) continue;;
            force--;
        }

        for (int i = 0; i < dominoesChars.length; i++) {
            if (forces[i] > 0) {
                dominoesChars[i] = 'R';
            } else if (forces[i] < 0) {
                dominoesChars[i] = 'L';
            }
        }

        return String.valueOf(dominoesChars);
    }
}
