package relocateMarbles;

import java.util.*;

public class RelocateMarbles {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            numSet.remove(moveFrom[i]);
            numSet.add(moveTo[i]);
        }
        List<Integer> answer = new ArrayList<>(numSet);
        Collections.sort(answer);
        return answer;
    }
}
