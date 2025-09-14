package vowelSpellchecker;

import java.util.HashMap;
import java.util.Map;

public class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> strIndexLowerMap = new HashMap<>();
        Map<String, String> strIndexMap = new HashMap<>();
        Map<String, String> strIndexVowelMap = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            if (!strIndexMap.containsKey(wordlist[i])) {
                strIndexMap.put(wordlist[i], wordlist[i]);
            }
            String lowered = wordlist[i].toLowerCase();
            if (!strIndexLowerMap.containsKey(lowered)) {
                strIndexLowerMap.put(lowered, wordlist[i]);
            }
            String vowelledStr = devowel(lowered);
            if (!strIndexVowelMap.containsKey(vowelledStr)) {
                strIndexVowelMap.put(vowelledStr, wordlist[i]);
            }
        }
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = strIndexMap.getOrDefault(queries[i], strIndexLowerMap.getOrDefault(queries[i].toLowerCase(),
                    strIndexVowelMap.getOrDefault(devowel(queries[i]).toLowerCase(), "")));
        }
        return ans;
    }

    private String devowel(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if ("aeiouAEIOU".indexOf(ch[i]) >= 0) ch[i] = '*';
        }
        return String.valueOf(ch);
    }

}
