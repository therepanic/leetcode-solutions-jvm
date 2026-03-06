package findTheSequenceOfStringsAppearedOnTheScreen;

import java.util.ArrayList;
import java.util.List;

public class FindTheSequenceOfStringsAppearedOnTheScreen {
    public List<String> stringSequence(String target) {
        StringBuilder sb = new StringBuilder();
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            char ch = 'a';
            sb.append(ch);
            char tar = target.charAt(i);
            while (ch != tar) {
                answer.add(sb.toString());
                if (ch == 'z') {
                    ch = 'a';
                } else {
                    ch++;
                }
                sb.setCharAt(sb.length() - 1, ch);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
}
