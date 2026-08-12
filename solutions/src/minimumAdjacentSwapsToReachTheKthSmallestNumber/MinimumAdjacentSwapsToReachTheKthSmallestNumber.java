package minimumAdjacentSwapsToReachTheKthSmallestNumber;

import java.util.Arrays;

public class MinimumAdjacentSwapsToReachTheKthSmallestNumber {
    public int getMinSwaps(String num, int k) {
        int[] perms = new int[num.length()];
        for (int i = 0; i < perms.length; i++) {
            perms[i] = num.charAt(i) - '0';
        }
        int[] a = perms.clone();
        getKPerm(a, k);
        return getMinSwaps(perms, a);
    }

    public void getKPerm(int[] perms, int k) {
        while (k != 0) {
            perm(perms);
            k--;
        }
    }
    public void perm(int[] perms) {
        int i = perms.length - 2;
        while (i >= 0 && perms[i] >= perms[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = perms.length - 1;
            while (j > i && perms[j] <= perms[i]) {
                j--;
            }
            int c = perms[i];
            perms[i] = perms[j];
            perms[j] = c;
        }
        Arrays.sort(perms, i + 1, perms.length);
    }

    public int getMinSwaps(int[] number, int[] kthSmallestNumber){
        int c = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] == kthSmallestNumber[i]) {
                continue;
            }
            int j = i + 1;
            while (j < number.length && number[j] != kthSmallestNumber[i]) {
                j++;
            }
            while (j > i) {
                int d = number[j];
                number[j] = number[j - 1];
                number[j - 1] = d;
                c++;
                j--;
            }
        }
        return c;
    }
}
