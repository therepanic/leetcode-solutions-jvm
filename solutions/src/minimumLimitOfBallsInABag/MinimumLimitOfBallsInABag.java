package minimumLimitOfBallsInABag;

public class MinimumLimitOfBallsInABag {
    public static int minimumSize(int[] nums, int maxOperations) {
        int r = Integer.MIN_VALUE;
        for (int num : nums) {
            r = Math.max(r, num);
        }

        int l = 1;

        while (l < r) {
            int mid = (r + l) / 2;
            boolean isOk = true;
            int operations = 0;

            for (int num : nums) {
                operations += (num - 1) / mid;
                if (operations > maxOperations) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
