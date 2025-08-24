package evaluateTheBracketPairsOfAString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateTheBracketPairsOfAString {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();
        for (var entry : knowledge) {
            knowledgeMap.put(entry.get(0), entry.get(1));
        }
        StringBuilder act = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        boolean active = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                active = true;
            } else if (ch == ')') {
                active = false;
                answer.append(knowledgeMap.getOrDefault(act.toString(), "?"));
                act.setLength(0);
            } else {
                if (active) {
                    act.append(ch);
                } else {
                    answer.append(ch);
                }
            }
        }
        return answer.toString();
    }
}
