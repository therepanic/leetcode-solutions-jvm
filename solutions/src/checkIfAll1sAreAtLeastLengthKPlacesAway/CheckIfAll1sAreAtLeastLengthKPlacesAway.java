package checkIfAll1sAreAtLeastLengthKPlacesAway;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int cord = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (cord != -1 && i - cord - 1 < k) {
                    return false;
                }
                cord = i;
            }
        }
        return true;
    }
}
