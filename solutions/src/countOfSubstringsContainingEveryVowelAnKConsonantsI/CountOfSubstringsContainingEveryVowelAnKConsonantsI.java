package countOfSubstringsContainingEveryVowelAnKConsonantsI;

public class CountOfSubstringsContainingEveryVowelAnKConsonantsI {
    public static int countOfSubstrings(String word, int k) {
        char[] symbols = word.toCharArray();
        int[] count = new int[26];
        int l = 0;
        int c = 0;
        int notVowels = 0;
        for (int r = 0; r < symbols.length; r++) {
            count[symbols[r] - 'a']++;
            if (symbols[r] != 'a' && symbols[r] != 'e' && symbols[r] != 'i' && symbols[r] != 'o' && symbols[r] != 'u') {
                notVowels++;
            }
            while (notVowels > k) {
                char ch = symbols[l];
                count[ch - 'a']--;
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    notVowels--;
                }
                l++;
            }
            if (notVowels == k && count[0] >= 1 && count['e' - 'a'] >= 1 && count['i' - 'a'] >= 1 && count['o' - 'a'] >= 1 && count['u' - 'a'] >= 1) {
                c++;
                int lCopy = l;
                int[] countCopy = count.clone();
                int notVowelsCopy = notVowels;
                do {
                    char ch = symbols[lCopy];
                    countCopy[ch - 'a']--;
                    if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                        notVowelsCopy--;
                    }
                    lCopy++;
                    if (notVowelsCopy == k && countCopy[0] >= 1 && countCopy['e' - 'a'] >= 1 && countCopy['i' - 'a'] >= 1 && countCopy['o' - 'a'] >= 1 && countCopy['u' - 'a'] >= 1) {
                        c++;
                    }
                } while (notVowelsCopy >= k && lCopy <= r);
            }
        }
        return c;
    }
}
