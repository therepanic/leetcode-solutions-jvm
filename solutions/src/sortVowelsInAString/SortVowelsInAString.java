package sortVowelsInAString;

import java.util.*;

public class SortVowelsInAString {
    public String sortVowels(String s) {
        List<Character> chars = new ArrayList<>();
        Queue<Integer> vowelIndexes = new ArrayDeque<>();
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            char c = sChars[i];
            char ch = Character.toLowerCase(c);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                chars.add(c);
                vowelIndexes.add(i);
            }
        }
        Collections.sort(chars);
        for (int i = 0; i < chars.size(); i++) {
             sChars[vowelIndexes.poll()] = chars.get(i);
        }
        return String.valueOf(sChars);
    }
}
