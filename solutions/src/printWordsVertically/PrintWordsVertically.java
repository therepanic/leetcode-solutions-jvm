package printWordsVertically;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public static List<String> printVertically(String s) {
        String[] split = s.split(" ");
        int maxLength = 0;
        for (int i = 0; i < split.length; i++) {
            maxLength = Math.max(maxLength, split[i].length());
        }
        List<String> words = new ArrayList<>(maxLength);
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int lastIndex = 0;
            for (int j = 0; j < split.length; j++) {
                if (split[j].length() > i) {
                    lastIndex = j;
                }
            }
            for (int j = 0; j <= lastIndex; j++) {
                if (split[j].length() <= i) {
                    temp.append(" ");
                } else {
                    temp.append(split[j].charAt(i));
                }
            }
            words.add(temp.toString());
            temp.setLength(0);
        }
        return words;
    }
}
