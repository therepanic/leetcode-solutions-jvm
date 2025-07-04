package iteratorForCombination;

import java.util.ArrayList;
import java.util.List;

public class CombinationIterator {

    private final List<String> strs;
    private int i;

    public CombinationIterator(String characters, int combinationLength) {
        this.strs = new ArrayList<>();
        bypass("", 0, characters.toCharArray(), combinationLength, this.strs);
    }

    public String next() {
        if (i < strs.size()) {
            String val = strs.get(i);
            i++;
            return val;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return i < strs.size();
    }

    public void bypass(String str, int it, char[] chars, int maxSize, List<String> values) {
        if (str.length() == maxSize) {
            values.add(str);
            return;
        }
        for (int i = it; i < chars.length; i++) {
            bypass(str + chars[i], i + 1, chars, maxSize, values);
        }
    }

}
