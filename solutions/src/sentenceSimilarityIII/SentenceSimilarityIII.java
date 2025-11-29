package sentenceSimilarityIII;

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        String[] split1 = sentence1.split(" ");
        String[] split2 = sentence2.split(" ");
        int start = 0;
        int end1 = split1.length - 1;
        int end2 = split2.length - 1;
        while (start < split1.length && split1[start].equals(split2[start])) {
            start++;
        }
        while (end1 >= 0 && split1[end1].equals(split2[end2])) {
            end1--;
            end2--;
        }
        return end1 < start;
    }
}
