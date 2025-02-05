package makeNumberOfDistinctCharactersEqual;

public class MakeNumberOfDistinctCharactersEqual {
    public boolean isItPossible(String word1, String word2) {
        int[] word1Chars = new int[26];
        int[] word2Chars = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1Chars[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            word2Chars[word2.charAt(i) - 'a']++;
        }
        int uniqueFirst = 0, uniqueSecond = 0;
        for (int i = 0; i < 26; i++) {
            if (word1Chars[i] > 0) uniqueFirst++;
            if (word2Chars[i] > 0) uniqueSecond++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (word1Chars[i] > 0 && word2Chars[j] > 0) {
                    if (i == j) {
                        if (uniqueFirst == uniqueSecond) return true;
                    } else {
                        int newUniqueFirst = uniqueFirst;
                        int newUniqueSecond = uniqueSecond;
                        if (word1Chars[i] == 1) newUniqueFirst--;
                        if (word1Chars[j] == 0) newUniqueFirst++;
                        if (word2Chars[j] == 1) newUniqueSecond--;
                        if (word2Chars[i] == 0) newUniqueSecond++;
                        if (newUniqueFirst == newUniqueSecond) return true;
                    }
                }
            }
        }
        return false;
    }
}
