package checkIfAllCharactersHaveEqualNumberOfOccurrences;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (c == 0 && counts[i] != 0) {
                c = counts[i];
            } else if (c != 0 && counts[i] != 0 && c != counts[i]) {
                return false;
            }
        }
        return true;
    }
}
