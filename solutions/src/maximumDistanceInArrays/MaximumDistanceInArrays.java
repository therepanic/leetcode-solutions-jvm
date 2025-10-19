package maximumDistanceInArrays;

import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min1 = Integer.MAX_VALUE;
        int min1Arr = -1;
        int min2 = Integer.MAX_VALUE;
        int min2Arr = -1;

        int max1 = Integer.MIN_VALUE;
        int max1Arr = -1;
        int max2 = Integer.MIN_VALUE;
        int max2Arr = -1;

        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).getFirst() <= min1) {
                min2 = min1;
                min2Arr = min1Arr;

                min1 = arrays.get(i).getFirst();
                min1Arr = i;
            } else if (arrays.get(i).getFirst() < min2) {
                min2 = arrays.get(i).getFirst();
                min2Arr = i;
            }
            if (arrays.get(i).getLast() >= max1) {
                max2 = max1;
                max2Arr = max1Arr;

                max1 = arrays.get(i).getLast();
                max1Arr = i;
            } else if (arrays.get(i).getLast() > max2) {
                max2 = arrays.get(i).getLast();
                max2Arr = i;
            }
        }
        int ans = -1;
        if (min1 != Integer.MAX_VALUE && max1 != Integer.MIN_VALUE && min1Arr != max1Arr) {
            ans = Math.max(ans, Math.abs(min1 - max1));
        }
        if (min1 != Integer.MAX_VALUE && max2 != Integer.MIN_VALUE && min1Arr != max2Arr) {
            ans = Math.max(ans, Math.abs(min1 - max2));
        }
        if (min2 != Integer.MAX_VALUE && max1 != Integer.MIN_VALUE && min2Arr != max1Arr) {
            ans = Math.max(ans, Math.abs(min2 - max1));
        }
        if (min2 != Integer.MAX_VALUE && max2 != Integer.MIN_VALUE && min2Arr != max2Arr) {
            ans = Math.max(ans, Math.abs(min2 - max2));
        }
        return ans;
    }
}
