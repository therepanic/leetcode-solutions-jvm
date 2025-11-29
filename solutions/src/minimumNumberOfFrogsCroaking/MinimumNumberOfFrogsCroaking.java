package minimumNumberOfFrogsCroaking;

public class MinimumNumberOfFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int symC = 0;
        int symR = 0;
        int symO = 0;
        int symA = 0;
        int symK = 0;
        int countC = 0;
        int maxFrogs = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') {
                countC++;
                symC++;
            } else if (ch == 'r') {
                symR++;
                if (symR > symC) return -1;
            } else if (ch == 'o') {
                symO++;
                if (symO > symR) return -1;
            } else if (ch == 'a') {
                symA++;
                if (symA > symO) return -1;
            } else if (ch == 'k') {
                countC--;
                symK++;
                if (symK > symA) return -1;
            }
            maxFrogs = Math.max(maxFrogs, countC);
        }
        if (symC > symR) return -1;
        if (symR > symO) return -1;
        if (symO > symA) return -1;
        if (symA > symK) return -1;
        return croakOfFrogs.length() == symC + symR + symO + symA + symK ? maxFrogs : -1;
    }
}
