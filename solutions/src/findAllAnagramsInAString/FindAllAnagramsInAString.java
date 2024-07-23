package findAllAnagramsInAString;

import java.util.*;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        Set<Integer> usedIndices = new HashSet<>();

        Map<Character, Integer> pMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            if (pMap.containsKey(c)) {
                pMap.put(c, pMap.get(c) + 1);
            } else {
                pMap.put(c, 1);
            }
        }

        Map<Character, Integer> sMap = new HashMap<>();

        char[] sChars = s.toCharArray();
        int l = 0;

        int wordLength = 0;
        for (int r = 0; r < s.length(); r++) {
            if (pMap.containsKey(sChars[r])) {
                if (sMap.containsKey(sChars[r])) {
                    sMap.put(sChars[r], sMap.get(sChars[r]) + 1);
                } else {
                    sMap.put(sChars[r], 1);
                }

                wordLength++;

                while (pMap.get(sChars[r]) < sMap.get(sChars[r])) {
                    if (sMap.get(sChars[l]) > 1) {
                        sMap.put(sChars[l], sMap.get(sChars[l]) - 1);
                    } else {
                        sMap.remove(sChars[l]);
                    }
                    wordLength--;

                    l++;
                }


                if (sMap.size() == pMap.size() && wordLength == p.length() && !usedIndices.contains(l)) {
                    indices.add(l);
                    usedIndices.add(l);
                }


            } else {
                while (l <= r) {
                    wordLength = Math.max(0, wordLength - 1);
                    if (sMap.containsKey(sChars[l]) && sMap.get(sChars[l]) > 1) {
                        sMap.put(sChars[l], sMap.get(sChars[l]) - 1);
                    } else {
                        sMap.remove(sChars[l]);
                    }

                    l++;
                }
            }
        }

        return indices;
    }
}
