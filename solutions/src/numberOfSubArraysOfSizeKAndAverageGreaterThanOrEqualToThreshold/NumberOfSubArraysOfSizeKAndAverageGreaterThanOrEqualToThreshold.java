package numberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;

        int l = 0;

        int count = 0;
        for (int r = 0; r < arr.length; r++) {
            if (r - l + 1 > k) {
                sum -= arr[l];
                l++;
            }

            sum += arr[r];

            if (r - l + 1 == k && sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}
