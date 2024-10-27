package wordsWithinTwoEditsOfDictionary;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> answer = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (word.length() != query.length()) continue;

                int count = 0;

                for (int i = 0; i < word.length(); i++) {
                    if (query.charAt(i) == word.charAt(i)) count++;
                }

                if (query.length() - count <= 2) {
                    answer.add(query);
                    break;
                }
            }
        }

        return answer;
    }
}
