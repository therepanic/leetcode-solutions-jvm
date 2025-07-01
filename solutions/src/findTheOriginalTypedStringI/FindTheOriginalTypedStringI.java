package findTheOriginalTypedStringI;

import java.util.ArrayList;
import java.util.List;

public class FindTheOriginalTypedStringI {

    public int possibleStringCount(String word) {
        char lastCh = '-';
        int c = 1;
        List<Integer> counts = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            if (ch == lastCh) {
                c++;
            } else {
                counts.add(c);
                c = 1;
                lastCh = ch;
            }
        }
        counts.add(c);
        int answer = 1;
        for (int count : counts) {
            answer += count - 1;
        }
        return answer;
    }

}
