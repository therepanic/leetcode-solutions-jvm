package findCommonCharacters;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[][] counts = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                counts[i][words[i].charAt(j) - 'a']++;
            }
        }
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int mn = Integer.MAX_VALUE;
            for (int w = 0; w < counts.length; w++) {
                mn = Math.min(mn, counts[w][i]);
                if (mn == 0) {
                    break;
                }
            }
            char ch = (char) (i + 'a');
            while (mn > 0) {
                mn--;
                answer.add(ch + "");
            }
        }
        return answer;
    }
}
