package sumOfAllOddLengthSubarrays;

public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if ((i - j + 1) % 2 != 0) {
                    ans += sum;
                }
            }
        }
        return ans;
    }
}
