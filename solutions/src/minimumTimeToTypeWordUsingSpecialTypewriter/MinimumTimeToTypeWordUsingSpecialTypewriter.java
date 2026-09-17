package minimumTimeToTypeWordUsingSpecialTypewriter;

public class MinimumTimeToTypeWordUsingSpecialTypewriter {
    public int minTimeToType(String word) {
        int cur = 0;
        int ans = word.length();;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            int diff = Math.abs(ch - cur) % 26;
            ans += Math.min(26 - diff, diff);
            cur = ch;
        }
        return ans;
    }
}
