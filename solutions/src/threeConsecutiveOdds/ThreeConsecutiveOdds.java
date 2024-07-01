package threeConsecutiveOdds;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutive = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i - 1] % 2 != 0) {
                consecutive++;
            } else {
                consecutive = 0;
            }

            if (consecutive == 2) {
                return true;
            }
        }

        return false;
    }
}
