package buildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int c = 1;
        for (int i = 0; i < target.length; i++) {
            while (c != target[i]) {
                answer.add("Push");
                answer.add("Pop");
                c++;
            }
            answer.add("Push");
        }
        return answer;
    }
}
