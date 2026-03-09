package checkArrayFormationThroughConcatenation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckArrayFormationThroughConcatenation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, List<Integer>> arrMap = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < pieces[i].length; j++) {
                a.add(pieces[i][j]);
            }
            arrMap.put(pieces[i][0], a);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.addAll(arrMap.getOrDefault(arr[i], List.of()));
        }
        if (ans.size() != arr.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (ans.get(i) != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
