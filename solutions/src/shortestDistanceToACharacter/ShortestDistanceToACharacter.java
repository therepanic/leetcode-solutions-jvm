package shortestDistanceToACharacter;

import java.util.TreeSet;

public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String s, char c) {
        char[] sChars = s.toCharArray();
        TreeSet<Integer> indexes = new TreeSet<>();
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] == c) {
                indexes.add(i);
            }
        }
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] != c) {
                Integer lower = indexes.lower(i);
                Integer higher = indexes.higher(i);
                if (lower == null && higher == null) continue;
                if (lower == null || higher == null) {
                    ans[i] = lower == null ? higher - i : i - lower;
                } else {
                    int a = Math.abs(i - lower);
                    int b = Math.abs(i - higher);
                    ans[i] = Math.min(a, b);
                }
            }
        }
        return ans;
    }
}
