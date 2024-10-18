package letterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder(s);

        List<String> answer = new ArrayList<>();

        bypass(sb, answer, 0);

        return answer;
    }

    public void bypass(StringBuilder sb, List<String> answer, int index) {
        if (index >= sb.length()) {
            answer.add(sb.toString());
        }

        for (int i = index; i < sb.length(); i++) {
            if (Character.isLetter(sb.charAt(i))) {
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));

                bypass(sb, answer, i + 1);

                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));

                bypass(sb, answer, i + 1);

                break;
            } else if (i + 1 == sb.length()) {
                answer.add(sb.toString());
            }
        }
    }
}
