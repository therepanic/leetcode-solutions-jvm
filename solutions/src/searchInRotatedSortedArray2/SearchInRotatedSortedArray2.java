package searchInRotatedSortedArray2;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        for (int num : nums) if (num == target) return true;
        return false;
    }
}
