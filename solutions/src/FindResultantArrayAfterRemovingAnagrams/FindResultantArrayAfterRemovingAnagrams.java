package FindResultantArrayAfterRemovingAnagrams;

import java.util.*;

public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] contains = new int[26];
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                for (char c : words[i].toCharArray()) {
                    contains[c - 'a']++;
                }
                ans.add(words[i]);
            } else {
                int[] th = new int[26];
                for (char c : words[i].toCharArray()) {
                    th[c - 'a']++;
                }
                if (!Arrays.equals(contains, th)) {
                    ans.add(words[i]);
                }
                contains = th;
            }
        }
        return ans;
    }
}
