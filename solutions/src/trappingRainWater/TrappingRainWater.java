package trappingRainWater;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int[] leftBoundary = new int[height.length];
        int[] rightBoundary = new int[height.length];

        int maxValue = 0;

        for (int i = 0; i < height.length; i++) {
            maxValue = Math.max(maxValue, height[i]);

            leftBoundary[i] = maxValue;
        }
        maxValue = 0;

        for (int i = height.length - 1; i >= 0; i--) {
            maxValue = Math.max(maxValue, height[i]);

            rightBoundary[i] = maxValue;
        }

        int trapCount = 0;

        for (int i = 0; i < height.length; i++) {
            trapCount += Math.min(leftBoundary[i], rightBoundary[i]) - height[i];
        }

        return trapCount;
    }
}
