package convertAnArrayIntoA2DArrayWithConditions;

import java.util.ArrayList;
import java.util.List;

public class ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] valCount = new int[201];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            valCount[nums[i]]++;
            if (valCount[nums[i]] == 1) {
                c++;
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        while (c != 0) {
            List<Integer> values = new ArrayList<>();
            for (int i = 1; i < valCount.length; i++) {
                if (valCount[i] == 0) continue;
                values.add(i);
                valCount[i]--;
                if (valCount[i] == 0) {
                    c--;
                }
            }
            answer.add(values);
        }
        return answer;
    }
}
