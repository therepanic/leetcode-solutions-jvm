package rankTransformOfAnArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        int[] newArr = arr.clone();
        Arrays.sort(newArr);
        int rank = 1;
        for (int val : newArr) {
            if (rankMap.containsKey(val)) continue;
            rankMap.put(val, rank);
            rank++;
        }
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = rankMap.get(arr[i]);
        }
        return answer;
    }
}
