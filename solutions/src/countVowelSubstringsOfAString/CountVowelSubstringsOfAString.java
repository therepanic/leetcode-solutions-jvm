package countVowelSubstringsOfAString;

public class CountVowelSubstringsOfAString {
    public int countVowelSubstrings(String word) {
        int ans = 0;
        for (int it = 0; it < word.length(); it++) {
            boolean[] act = new boolean[26];
            for (int i = it; i < word.length(); i++) {
                char ch = word.charAt(i);
                act[ch - 'a'] = true;
                if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                    break;
                }
                if (act[0] && act['e' - 'a'] && act['i' - 'a'] && act['o' - 'a'] && act['u' - 'a']) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
