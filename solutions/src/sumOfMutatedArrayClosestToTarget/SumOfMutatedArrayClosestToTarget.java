package sumOfMutatedArrayClosestToTarget;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length && arr[i] * (arr.length - i) < target) {
            target -= arr[i];
            i++;
        }
        if (i == arr.length) {
            return arr[i - 1];
        }
        int ans = target / (arr.length - i);
        int diff1 = Math.abs(target - ans * (arr.length - i));
        int diff2 = Math.abs(target - (ans + 1) * (arr.length - i));
        if (diff2 < diff1) {
            ans++;
        }
        return ans;
    }
}
