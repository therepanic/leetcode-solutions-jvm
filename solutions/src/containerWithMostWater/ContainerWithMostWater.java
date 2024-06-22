package containerWithMostWater;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int most = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            most = Math.max(most, Math.min(height[l], height[r]) * (r - l));

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return most;
    }
}
