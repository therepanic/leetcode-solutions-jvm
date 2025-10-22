package makingFileNamesUnique;

import java.util.HashMap;
import java.util.Map;

public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> nameMap = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String str = names[i];
            int c = nameMap.getOrDefault(str, 0);
            while(nameMap.containsKey((c == 0 ? str : str + "(" + c + ")"))) {
                c++;
            }
            String sv = (c == 0 ? str : str + "(" + c + ")");
            ans[i] = sv;
            nameMap.put(sv, 1);
            nameMap.put(str, c + 1);
        }
        return ans;
    }
}
