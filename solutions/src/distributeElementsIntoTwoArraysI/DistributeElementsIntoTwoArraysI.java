package distributeElementsIntoTwoArraysI;

import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>(List.of(nums[0]));
        List<Integer> arr2 = new ArrayList<>(List.of(nums[1]));
        for (int i = 2; i < nums.length; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] ans = new int[arr1.size() + arr2.size()];
        for (int i = 0; i < arr1.size(); i++) {
            ans[i] = arr1.get(i);
        }
        for (int i = arr1.size(); i < ans.length; i++) {
            ans[i] = arr2.get(i - arr1.size());
        }
        return ans;
    }
}
