package repeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            char[] sChars = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            int l = 0;

            Map<String, Integer> strCountMap = new HashMap<>();
            List<String> answer = new ArrayList<>();
            for (int r = 0; r < s.length(); r++) {
                sb.append(sChars[r]);
                if (r - l + 1 > 10) {
                    sb.deleteCharAt(0);
                    l++;
                }
                if (strCountMap.containsKey(sb.toString()) && strCountMap.get(sb.toString()) == 1) {
                    answer.add(sb.toString());
                }
                strCountMap.put(sb.toString(), strCountMap.getOrDefault(sb.toString(), 0) + 1);
            }
            return answer;
        }

        public static long hash(String s) {
            int p = 31;
            int m = (int) (1e9 + 7);
            long hash = 0;
            long pow = 1;
            for (char c : s.toCharArray()) {
                hash = hash + ((c - 'a' + 1) * pow) % m;
                pow = (pow * p) % m;
            }
            return hash;
        }
    }
}
