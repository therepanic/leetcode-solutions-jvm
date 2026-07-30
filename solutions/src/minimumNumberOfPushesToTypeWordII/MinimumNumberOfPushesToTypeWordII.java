package minimumNumberOfPushesToTypeWordII;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfPushesToTypeWordII {
    public int minimumPushes(String word) {
        int[][] freq = new int[26][2];
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            freq[ch][0] = ch;
            freq[ch][1]++;
        }
        int ans = 0;
        Arrays.sort(freq, Comparator.comparingInt(p -> p[1]));
        int c = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            ans += ((c / 8) + 1) * freq[i][1];
            c++;
        }
        return ans;
    }
}
