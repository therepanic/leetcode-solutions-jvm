package countPrefixAndSuffixPairsI;

public class CountPrefixAndSuffixPairsI {
    public int countPrefixSuffixPairs(String[] words) {
        int c = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    c++;
                }
            }
        }
        return c;
    }

    public boolean isPrefixAndSuffix(String word1, String word2) {
        if (word2.length() < word1.length()) {
            return false;
        }
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return false;
            }
        }
        for (int i = word2.length() - word1.length(), j = 0; i < word2.length(); i++, j++) {
            if (word1.charAt(j) != word2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
