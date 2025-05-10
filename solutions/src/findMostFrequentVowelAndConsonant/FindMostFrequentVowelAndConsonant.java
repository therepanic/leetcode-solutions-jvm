package findMostFrequentVowelAndConsonant;

public class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxVowel = 0;
        int maxCons = 0;
        for (int i = 0; i < freq.length; i++) {
            char c = (char) (i + 'a');
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                maxVowel = Math.max(maxVowel, freq[i]);
            } else {
                maxCons = Math.max(maxCons, freq[i]);
            }
        }
        return maxCons + maxVowel;
    }
}
