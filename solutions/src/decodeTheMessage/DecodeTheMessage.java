package decodeTheMessage;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        int[] s = new int[26];
        boolean[] a = new boolean[26];
        int it = 0;
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ') continue;
            int d = key.charAt(i) - 'a';
            if (!a[d]) {
                s[d] = it;
                it++;
                a[d] = true;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                ans.append(' ');
            } else {
                ans.append((char) (s[ch - 'a'] + 'a'));
            }
        }
        return ans.toString();
    }
}
