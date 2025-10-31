package theTwoSneakNumbersOfDigitville;

public class TheTwoSneakNumbersOfDigitville {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr = new int[101];
        int[] ans = new int[2];
        int it = 0;
        for (int v : nums) {
            arr[v]++;
            if (arr[v] == 2) {
                ans[it] = v;
                it++;
            }
        }
        return ans;
    }
}
