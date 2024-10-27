package maximumPrimeDifference;

public class MaximumPrimeDifference {
    public int maximumPrimeDifference(int[] nums) {
        int mostNum = 0;

        for (int num : nums) {
            mostNum = Math.max(num, mostNum);
        }

        boolean[] simples = new boolean[mostNum + 1];

        bypass(simples);

        int lowIndex = Integer.MAX_VALUE;
        int highIndex = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (!simples[nums[i]] && lowIndex > i) {
                lowIndex = i;
            }

            if (!simples[nums[i]] && highIndex < i) {
                highIndex = i;
            }
        }


        return highIndex - lowIndex;
    }

    public void bypass(boolean[] simples) {
        simples[1] = true;

        for (int i = 2; i * i < simples.length; i++) {
            if (!simples[i]) {
                for (int j = i * i; j < simples.length; j += i) {
                    simples[j] = true;
                }
            }
        }
    }
}
