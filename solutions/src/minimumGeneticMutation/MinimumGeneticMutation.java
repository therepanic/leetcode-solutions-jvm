package minimumGeneticMutation;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Set<String> checkedWords = new HashSet<>();
        char[] mutation = new char[] {'A', 'C', 'G', 'T'};
        int count = 0;
        Queue<String> queue = new ArrayDeque<>(List.of(startGene));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endGene)) return count;
                char[] word = poll.toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char orig = word[j];
                    for (char c : mutation) {
                        word[j] = c;
                        String wordStr = String.valueOf(word);
                        if (bankSet.contains(wordStr) && checkedWords.add(wordStr)) {
                            queue.add(wordStr);
                        }
                    }
                    word[j] = orig;
                }
            }
            count++;
        }
        return -1;
    }
}
