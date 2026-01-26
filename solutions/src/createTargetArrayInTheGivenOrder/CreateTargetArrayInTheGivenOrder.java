package createTargetArrayInTheGivenOrder;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ansList.add(index[i], nums[i]);
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
