package removeDuplicateLetters;

import java.util.*;

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Set<Character> characterSet = new HashSet<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) - 1);
            if (characterSet.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.getLast() > c && map.get(stack.getLast()) > 0) {
                characterSet.remove(stack.pollLast());
            }

            characterSet.add(c);
            stack.addLast(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
