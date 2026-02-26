package replaceQuestionMarksInStringToMinimizeItsValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ReplaceQuestionMarksInStringToMinimizeItsValue {
    public String minimizeStringValue(String s) {
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '?') {
                continue;
            }
            c[s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1[1] == p2[1]) {
                return Integer.compare(p1[0], p2[0]);
            } else {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        for (int i = 0; i < 26; i++) {
            heap.add(new int[] {i, c[i]});
        }
        List<Character> chosen = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int[] cur = heap.poll();
                chosen.add((char)(cur[0] + 'a'));
                cur[1]++;
                heap.add(cur);
            }
        }
        Collections.sort(chosen);
        int k = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (sb.charAt(i) == '?') {
                sb.setCharAt(i, chosen.get(k++));
            }
        }
        return sb.toString();
    }

}
