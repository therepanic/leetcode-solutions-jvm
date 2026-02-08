package baseballGame;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] operations) {
        List<Integer> values = new ArrayList<>();
        for (String op : operations) {
            if (op.equals("+")) {
                values.add(values.getLast() + values.get(values.size() - 2));
            } else if (op.equals("D")) {
                values.add(values.getLast() * 2);
            } else if (op.equals("C")) {
                values.removeLast();
            } else {
                values.add(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return sum;
    }
}
