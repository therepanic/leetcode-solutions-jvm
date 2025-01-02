package countVowelStringsInRanges;

import java.util.Set;

public class CountVowelStringsInRanges {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int i = 0; i < words.length; i++) {
            prefix[i] = (vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) ? prefix[i] + 1 : prefix[i];

            if (i + 1 < words.length) {
                prefix[i + 1] = prefix[i];
            }
        }

        int[] answer = new int[queries.length];
        int it = 0;

        for (int[] query : queries) {
            if (query[0] - 1 < 0) {
                answer[it] = prefix[query[1]];
            } else {
                answer[it] = prefix[query[1]] - prefix[query[0] - 1];
            }
            it++;
        }
        return answer;
    }
}
