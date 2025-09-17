package restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return List.of();
        List<String> ans = new ArrayList<>();
        brut(s, "", 0, 0, ans);
        return ans;
    }

    public void brut(String mainS, String s, int it, int c, List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = it; i < Math.min(it + 3, mainS.length()); i++) {
            sb.append(mainS.charAt(i));
            int num = Integer.parseInt(sb.toString());
            if (num > 255 || sb.length() > 1 && sb.charAt(0) == '0') break;
            if (c + 1 == 4) {
                if (it + sb.length() == mainS.length()) {
                    if (s.isEmpty()) {
                        strs.add(sb.toString());
                    } else {
                        strs.add(s + "." + sb);
                    }
                }
            } else {
                brut(mainS, s.isEmpty() ? sb.toString() : s + "." + sb, i + 1, c + 1, strs);
            }
        }
    }
}
