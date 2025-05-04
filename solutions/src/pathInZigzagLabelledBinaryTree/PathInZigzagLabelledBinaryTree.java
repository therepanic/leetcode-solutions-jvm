package pathInZigzagLabelledBinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public static List<Integer> pathInZigZagTree(int label) {
        int level = (int) Math.floor(Math.log(label) / Math.log(2)) + 1;
        int min = (int) Math.pow(2, level - 1);
        int max = (int) Math.pow(2, level) - 1;
        int node = max + min - label;
        List<Integer> answer = new ArrayList<>();
        while (node >= 1) {
            answer.add(label);
            node /= 2;
            label = node;
            level--;
            min = (int) Math.pow(2, level - 1);
            max = (int) Math.pow(2, level) - 1;
            node = max + min - label;
        }
        Collections.reverse(answer);
        return answer;
    }
}
