package largestTimeForGivenDigits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] arr) {
        List<String> ans = new ArrayList<>();
        bypass(0, arr, new ArrayList<>(), ans);
        Collections.sort(ans);
        return ans.isEmpty() ? "" : ans.getLast();
    }

    public void bypass(int it, int[] arr, List<Integer> used, List<String> ans) {
        if (it == 1 && (arr[used.getLast()] < 0 || arr[used.getLast()] > 2)) return;
        if (it == 2) {
            int h1 = arr[used.get(0)];
            int h2 = arr[used.getLast()];
            if (h1 == 2) {
                if (h2 > 3) return;
            }
        }
        if (it == 3 && (arr[used.getLast()] < 0 || arr[used.getLast()] > 5)) return;
        if (it == 4 && (arr[used.getLast()] < 0 || arr[used.getLast()] > 9)) return;
        if (it == 4) {
            StringBuilder answer = new StringBuilder();
            int c = 0;
            for (int val : used) {
                answer.append(arr[val]);
                c++;
                if (c == 2) {
                    answer.append(":");
                }
            }
            ans.add(answer.toString());
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used.contains(i)) continue;
            List<Integer> usedCloned = new ArrayList<>(used);
            usedCloned.add(i);
            bypass(it + 1, arr, usedCloned, ans);
        }
    }
}
