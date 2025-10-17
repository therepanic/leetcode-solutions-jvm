package groupsOfSpecialEquivalentStrings;

import java.util.*;

public class GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            List<Character> even = new ArrayList<>();
            List<Character> odd = new ArrayList<>();
            for (int i = 0; i < word.length(); i += 2) {
                even.add(word.charAt(i));
            }
            for (int i = 1; i < word.length(); i += 2) {
                odd.add(word.charAt(i));
            }
            Collections.sort(even);
            Collections.sort(odd);
            StringBuilder s = new StringBuilder();
            for (char c : even) {
                s.append(c);
            }
            for (char c : odd) {
                s.append(c);
            }
            wordSet.add(s.toString());
        }
        return wordSet.size();
    }
}
