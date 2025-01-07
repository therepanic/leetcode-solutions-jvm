package carPooling;

public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        int maxC = 0;
        for (int[] trip : trips) {
            maxC = Math.max(trip[2], maxC);
        }

        int[] prefix = new int[maxC + 1];

        for (int[] trip : trips) {
            prefix[trip[1]] += trip[0];

            prefix[trip[2]] -= trip[0];
        }

        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int num : prefix) {
            if (num > capacity) return false;
        }

        return true;
    }
}
