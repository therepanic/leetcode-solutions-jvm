package positionsOfLargeGroups;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        int index = 0;
        char[] chars = s.toCharArray();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (chars[i] != chars[index]) {
                if (i - index >= 3) {
                    ans.add(List.of(index, i - 1));
                }
                index = i;
            }
        }
        if (chars[chars.length - 1] == chars[index]) {
            if (chars.length - index >= 3) {
                ans.add(List.of(index, chars.length - 1));
            }
        }
        return ans;
    }
}
