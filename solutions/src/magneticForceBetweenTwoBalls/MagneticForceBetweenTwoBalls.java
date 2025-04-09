package magneticForceBetweenTwoBalls;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = position[position.length - 1] - position[0];
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int c = 1;
            int first = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - first >= mid) {
                    first = position[i];
                    c++;
                }
            }
            if (c >= m) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
