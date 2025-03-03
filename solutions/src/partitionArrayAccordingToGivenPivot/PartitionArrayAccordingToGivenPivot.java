package partitionArrayAccordingToGivenPivot;

public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int it = 0;
        int equals = 0;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                answer[it] = nums[i];
                it++;
            } else if (nums[i] == pivot) {
                equals++;
            }
        }
        while (equals != 0) {
            answer[it] = pivot;
            it++;
            equals--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                answer[it] = nums[i];
                it++;
            }
        }
        return answer;
    }
}
