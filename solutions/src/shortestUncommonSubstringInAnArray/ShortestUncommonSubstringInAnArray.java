package shortestUncommonSubstringInAnArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestUncommonSubstringInAnArray {

    public String[] shortestSubstrings(String[] arr) {
        String[] ans = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<String> strs = new ArrayList<>();
            for (int size = 1; size <= arr[i].length(); size++) {
                if (!strs.isEmpty()) break;
                int l = 0;
                loop: for (int r = 0; r < arr[i].length(); r++) {
                    if (r - l + 1 > size) {
                        l++;
                    } else if (r - l + 1 < size) {
                        continue;
                    }
                    String str = arr[i].substring(l, r + 1);
                    for (int j = 0; j < arr.length; j++) {
                        if (j == i) continue;
                        if (arr[j].length() >= str.length() && arr[j].contains(str)) {
                            continue loop;
                        }
                    }
                    strs.add(str);
                }
            }
            Collections.sort(strs);
            if (strs.isEmpty()) {
                ans[i] = "";
            } else {
                ans[i] = strs.getFirst();
            }
        }
        return ans;
    }
}
