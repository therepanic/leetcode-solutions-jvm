package averageValueOfEvenNumbersThatAreDivisibleByThree;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    public int averageValue(int[] nums) {
        int a = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] % 3 == 0) {
                a += nums[i];
                c++;
            }
        }
        return c == 0 ? 0 : a / c;
    }
}
