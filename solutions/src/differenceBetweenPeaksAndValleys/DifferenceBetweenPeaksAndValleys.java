package differenceBetweenPeaksAndValleys;

public class DifferenceBetweenPeaksAndValleys {
    public int peakValleyDifference(int[] nums) {
        int valleys = 0, peaks = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                valleys += nums[i];
            }
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                peaks += nums[i];
            }
        }
        return valleys - peaks;
    }
}
