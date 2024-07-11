package trappingRainWater;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int currentMaxLeft = 0;
        int currentMaxRight = height.length - 1;

        int maxLeftValue = height[currentMaxLeft];
        int maxRightValue = height[currentMaxRight];

        int waterCount = 0;

        int i = 0;
        while (currentMaxLeft <= currentMaxRight) {
            waterCount += Math.max(0, Math.min(maxLeftValue, maxRightValue)) - height[i];

            if (height[currentMaxLeft] <= height[currentMaxRight]) {
                currentMaxLeft++;

                if (currentMaxLeft < height.length) {
                    maxLeftValue = Math.max(maxLeftValue, height[currentMaxLeft]);
                }
            } else {
                currentMaxRight--;

                if (currentMaxRight >= 0) {
                    maxRightValue = Math.max(maxRightValue, height[currentMaxRight]);
                }
            }
            i++;
        }

        return waterCount;
    }
}
