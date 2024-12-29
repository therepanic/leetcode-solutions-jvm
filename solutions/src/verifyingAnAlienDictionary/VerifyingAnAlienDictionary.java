package verifyingAnAlienDictionary;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String firstWord = words[i - 1];
            String secondWord = words[i];

            boolean isEqual = true;

            for (int j = 0; j < Math.min(firstWord.length(), secondWord.length()); j++) {
                int firstIndex = orderMap.get(firstWord.charAt(j));
                int secondIndex = orderMap.get(secondWord.charAt(j));

                if (firstIndex > secondIndex) {
                    return false;
                } else if (firstIndex < secondIndex) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual && firstWord.length() > secondWord.length()) {
                return false;
            }
        }

        return true;
    }
}
