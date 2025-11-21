package expressiveWords;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        List<int[]> arr = new ArrayList<>();
        char ch = s.charAt(0);
        int c = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                c++;
            } else {
                arr.add(new int[] {ch, c});
                c = 1;
                ch = s.charAt(i);
            }
        }
        arr.add(new int[] {ch, c});
        int ans = 0;
        first: for (int i = 0; i < words.length; i++) {
            int it = 0;
            ch = words[i].charAt(0);
            if (ch != (char) arr.getFirst()[0]) {
                continue;
            }
            c = 1;
            for (int j = 1; j < words[i].length(); j++) {
                if (words[i].charAt(j) == words[i].charAt(j - 1)) {
                    c++;
                } else {
                    if (arr.get(it)[1] != c && arr.get(it)[1] < 3) {
                        continue first;
                    }
                    if (c > arr.get(it)[1]) {
                        continue first;
                    }
                    it++;
                    c = 1;
                    ch = words[i].charAt(j);
                    if (arr.size() <= it || arr.get(it)[0] != (char) ch) {
                        continue first;
                    }
                }
            }
            if (it != arr.size() - 1) {
                continue;
            }
            if (arr.get(it)[1] != c && arr.get(it)[1] < 3) {
                continue;
            }
            if (c > arr.get(it)[1]) {
                continue;
            }
            ans++;
        }
        return ans;
    }
}
