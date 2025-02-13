package findTheWinnerOfAnArrayGame;

public class FindTheWinnerOfAnArrayGame {
    public static int getWinner(int[] arr, int k) {
        if (k >= arr.length) {
            int max = arr[0];
            for (int num : arr) {
                max = Math.max(max, num);
            }
            return max;
        }
        int cur = arr[0];
        int wins = 0;
        for (int i = 1; i < arr.length && wins < k; i++) {
            if (cur > arr[i]) {
                wins++;
            } else {
                wins = 1;
                cur = arr[i];
            }
        }
        return cur;
    }
}
