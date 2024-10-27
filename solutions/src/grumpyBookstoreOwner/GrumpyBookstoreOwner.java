package grumpyBookstoreOwner;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;

        int l = 0;
        int stat = 0;
        int maxStat = 0;
        for (int r = 0; r < customers.length; r++) {
            while (r - l + 1 > minutes) {
                if (grumpy[l] == 1) {
                    stat -= customers[l];
                }
                l++;
            }

            if (grumpy[r] == 1) {
                stat += customers[r];
            } else {
                sum += customers[r];
            }

            if (r - l + 1 == minutes) {
                maxStat = Math.max(stat, maxStat);
            }
        }

        return sum + maxStat;
    }
}
