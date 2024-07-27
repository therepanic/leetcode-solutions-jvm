package implementMagicDictionary;

import java.util.*;

public class MagicDictionary {
    private final Set<String> set;

    public MagicDictionary() {
        this.set = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        set.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        for (String word : set) {
            if (word.length() == searchWord.length()) {
                int missSymbols = 0;

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        missSymbols++;
                    }
                }

                if (missSymbols == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
