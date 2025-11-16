package groupThePeopleGivenTheGroupSizeTheyBelongTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> valMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            valMap.computeIfAbsent(groupSizes[i], p -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (var entry : valMap.entrySet()) {
            for (int i = entry.getKey() - 1; i < entry.getValue().size(); i += entry.getKey()) {
                answer.add(entry.getValue().subList(i - (entry.getKey() - 1), i + 1));
            }
        }
        return answer;
    }
}
