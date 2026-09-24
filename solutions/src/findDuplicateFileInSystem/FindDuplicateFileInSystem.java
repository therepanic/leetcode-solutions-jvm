package findDuplicateFileInSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentPathMap = new HashMap<>();
        for (String path : paths) {
            String[] after = path.split(" ");
            String val = after[0] + "/";
            for (int i = 1; i < after.length; i++) {
                String content = after[i].substring(after[i].indexOf('('), after[i].length() - 1);
                contentPathMap.computeIfAbsent(content, p -> new ArrayList<>()).add(val + (after[i].substring(0, after[i].indexOf('('))));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (var v : contentPathMap.values()) {
            if (v.size() > 1) {
                ans.add(v);
            }
        }
        return ans;
    }
}
