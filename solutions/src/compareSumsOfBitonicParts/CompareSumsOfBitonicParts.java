package compareSumsOfBitonicParts;

public class CompareSumsOfBitonicParts {
    public int compareBitonicSums(int[] nums) {
        long a = 0;
        long b = 0;
        boolean mode = false;
        for (int i = 0; i < nums.length; i++) {
            if (!mode && i < nums.length - 1 && nums[i] > nums[i + 1]) {
                a += nums[i];
                b += nums[i];
                mode = true;
            } else {
                if (!mode) {
                    a += nums[i];
                } else {
                    b += nums[i];
                }
            }
        }
        if (a == b) {
            return -1;
        } else if (a > b) {
            return 0;
        } else {
            return 1;
        }
    }
}
