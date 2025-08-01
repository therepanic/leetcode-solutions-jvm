package heaters;

import java.util.Arrays;

public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int c = 0;
        Arrays.sort(houses);
        for (int house : houses) {
            int lowerHeater = lower(heaters, house);
            int higherHeater = higher(heaters, house);
            int lowerRadius = Integer.MAX_VALUE;
            int higherRadius = Integer.MAX_VALUE;
            if (lowerHeater != -1) {
                lowerRadius = Math.abs(heaters[lowerHeater] - house);
            }
            if (higherHeater != -1) {
                higherRadius = Math.abs(heaters[higherHeater] - house);
            }
            c = Math.max(c, Math.min(lowerRadius, higherRadius));
        }
        return c;
    }

    public int lower(int[] arr, int val) {
        int l = 0;
        int v = -1;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > val) {
                r = mid - 1;
            } else {
                v = mid;
                l = mid + 1;
            }
        }
        return v;
    }

    public int higher(int[] arr, int val) {
        int l = 0;
        int v = -1;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > val) {
                v = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return v;
    }
}
