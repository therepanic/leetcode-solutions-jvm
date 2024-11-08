package shortEncodingOfWords;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords {
    public static int minimumLengthEncoding(String[] words) {
        Set<String> suffixes = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                suffixes.remove(word.substring(i));
            }
        }

        int count = 0;

        for (String word : suffixes) {
            count += word.length() + 1;
        }

        return count;
    }
}
