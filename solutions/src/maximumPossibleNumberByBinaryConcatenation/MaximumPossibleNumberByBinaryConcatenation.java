package maximumPossibleNumberByBinaryConcatenation;

public class MaximumPossibleNumberByBinaryConcatenation {
    public int maxGoodNumber(int[] nums) {
        return Math.max(collect(nums[0], nums[1], nums[2]),
                Math.max(
                        collect(nums[0], nums[2], nums[1]),
                        Math.max(
                                collect(nums[1], nums[0], nums[2]),
                                Math.max(
                                        collect(nums[1], nums[2], nums[0]),
                                        Math.max(
                                                collect(nums[2], nums[1], nums[0]),
                                                collect(nums[2], nums[0], nums[1])
                                        )
                                )
                        )
                ));
    }

    public int collect(int a, int b, int c) {
        String a1 = Integer.toBinaryString(a);
        String b1 = Integer.toBinaryString(b);
        String c1 = Integer.toBinaryString(c);
        return Integer.parseInt(a1 + b1 + c1, 2);
    }
}
