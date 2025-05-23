package guessNumberHigherOrLower;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int result = guess(mid);

            if (result == 0) {
                return mid;
            } else if (result == -1) {
                r = mid - 1;
            } else if (result == 1) {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int guess(int n) {
        return 0;
    }
}
