package numberOfGoodWaysToSplitAString;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int[] l = new int[26];
        int[] r = new int[26];

        int charsL = 0;
        int charsR = 0;

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            r[c - 'a']++;

            if (r[c - 'a'] == 1) {
                charsR++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            r[c - 'a']--;

            if (r[c - 'a'] == 0) {
                charsR--;
            }

            l[c - 'a']++;

            if (l[c - 'a'] == 1) {
                charsL++;
            }

            if (charsL == charsR) {
                answer++;
            }
        }

        return answer;
    }
}
