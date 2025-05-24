package findWordsContainingCharacter;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int index = word.indexOf(x);
            if (index != -1) {
                answer.add(i);
            }
        }
        return answer;
    }

}
