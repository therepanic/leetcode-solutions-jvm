package splitStringsBySeparator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        String sep = Pattern.quote(String.valueOf(separator));
        for (String v : words) {
            String[] split = v.split(sep);
            for (String a : split) {
                if (!a.isEmpty()) {
                    ans.add(a);
                }
            }
        }
        return ans;
    }
}
