package sortVowelsByFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortVowelsByFrequency {
    public String sortVowels(String s) {
        int[] appear = new int[26];
        Arrays.fill(appear, -1);
        int[][] count = new int[26][2];
        List<Integer> change = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                continue;
            }
            int it = ch - 'a';
            if (appear[it] == -1) {
                appear[it] = i;
            }
            count[it][0] = it;
            count[it][1]++;
            change.add(i);
        }
        Arrays.sort(count, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(appear[p1[0]], appear[p2[0]]);
            } else {
                return Integer.compare(p2[1], p1[1]);
            }
        });
        StringBuilder sb = new StringBuilder(s);
        int it = 0;
        for (int i = 0; i < change.size(); i++) {
            while (it < 26 && count[it][1] == 0) {
                it++;
            }
            if (it == 26) break;
            sb.setCharAt(change.get(i), (char) (count[it][0] + 'a'));
            count[it][1]--;
        }
        return sb.toString();
    }
}
