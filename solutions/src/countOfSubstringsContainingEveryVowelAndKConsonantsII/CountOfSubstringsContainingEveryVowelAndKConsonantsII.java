package countOfSubstringsContainingEveryVowelAndKConsonantsII;

public class CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public static long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }
    private static long atLeastK(String word, int k) {
        char[] symbols = word.toCharArray();
        int[] vowels = new int[5];
        int uniqueVowels = 0;
        int consonants = 0;
        int l = 0;
        long count = 0;

        for (int r = 0; r< symbols.length; r++) {
            char c = symbols[r];

            if (isVowel(c)) {
                int idx = getVowelIndex(c);
                if (vowels[idx] == 0) uniqueVowels++;
                vowels[idx]++;
            } else {
                consonants++;
            }

            while (uniqueVowels == 5 && consonants >= k) {
                count += symbols.length - r;

                char leftChar = symbols[l];
                if (isVowel(leftChar)) {
                    int idx = getVowelIndex(leftChar);
                    vowels[idx]--;
                    if (vowels[idx] == 0) uniqueVowels--;
                } else {
                    consonants--;
                }
                l++;
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static int getVowelIndex(char c) {
        switch (c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: throw new IllegalArgumentException("Not a vowel");
        }
    }
}
