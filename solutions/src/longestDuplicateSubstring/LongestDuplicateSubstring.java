package longestDuplicateSubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestDuplicateSubstring {
    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana"));
    }
    public static String longestDupSubstring(String s) {
        int p = 31;
        long m = (long) 1e17 + 7;

        int l = 1;
        int r = s.length();

        char[] sChars = s.toCharArray();

        String answer = "";

        while (l <= r) {
            int mid =  l + (r - l) / 2;

            long hash = 0;
            long pow = 1;

            for (int i = 0; i < mid; i++) {
                hash = (hash * p + (s.charAt(i) - 'a' + 1)) % m;
                if (i > 0) pow = (pow * p) % m;
            }

            int l1 = 0;

            String maxStr = "";

            Map<Long, Integer> hashesMap = new HashMap<>(Map.of(hash, 0));

            for (int r1 = mid; r1 < s.length(); r1++) {
                hash = (hash - (sChars[l1] - 'a' + 1) * pow % m + m) % m;
                l1++;

                hash = (hash * p + (sChars[r1] - 'a' + 1)) % m;

                if (hashesMap.containsKey(hash)) {
                    maxStr = s.substring(l1, r1 + 1);
                }

                hashesMap.put(hash, hashesMap.getOrDefault(hash, 0) + 1);
            }

            if (answer.length() < maxStr.length()) {
                l = mid + 1;
                answer = maxStr;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}
