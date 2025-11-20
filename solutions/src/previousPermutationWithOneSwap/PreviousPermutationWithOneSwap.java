package previousPermutationWithOneSwap;

public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return arr;
        }
        int j = arr.length - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }
        int val = arr[j];
        while (j >= i + 1 && arr[j - 1] == val) {
            j--;
        }
        int replace = arr[i];
        arr[i] = val;
        arr[j] = replace;
        return arr;
    }
}
