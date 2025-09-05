package longestWordInDictionaryThroughDeleting;

import java.util.Collections;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (p1, p2) -> {
            if (p1.length() == p2.length()) {
                return p1.compareTo(p2);
            } else {
                return Integer.compare(p2.length(), p1.length());
            }
        });
        for (int i = 0; i < dictionary.size(); i++) {
            int it = 0;
            int c = 0;
            String str = dictionary.get(i);
            for (int j = 0; j < str.length(); j++) {
                while (it < s.length() && s.charAt(it) != str.charAt((j))) {
                    it++;
                }
                if (it < s.length() && s.charAt(it) == str.charAt((j))) {
                    it++;
                    c++;
                }
            }
            if (c == str.length()) {
                return str;
            }
        }
        return "";
    }
}
