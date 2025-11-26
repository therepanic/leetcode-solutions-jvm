package findLatestGroupOfSizeM;

public class FindLatestGroupOfSizeM {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        int[] count = new int[n + 1];
        int[] length = new int[n + 2];
        int last = -1;
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int l = length[val - 1];
            int r = length[val + 1];
            int newSize = l + r + 1;
            if (l > 0) {
                count[l]--;
            }
            if (r > 0) {
                count[r]--;
            }
            length[val - l] = newSize;
            length[val + r] = newSize;
            count[newSize]++;
            if (count[m] > 0) {
                last = i + 1;
            }
        }
        return last;
    }
}
