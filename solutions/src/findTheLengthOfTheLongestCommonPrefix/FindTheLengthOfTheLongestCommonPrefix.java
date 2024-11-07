package findTheLengthOfTheLongestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

public class FindTheLengthOfTheLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();

        for (int num : arr1) {
            StringBuilder s = new StringBuilder(String.valueOf(num));
            int sLength = s.length();
            for (int i = 0; i < sLength; i++) {
                set.add(s.toString());

                s.deleteCharAt(s.length() - 1);
            }
        }

        int answer = 0;
        for (int num : arr2) {
            StringBuilder s = new StringBuilder(String.valueOf(num));
            int sLength = s.length();

            for (int i = 0; i < sLength; i++) {
                if (set.contains(s.toString())) {
                    answer = Math.max(answer, s.length());
                    break;
                }
                s.deleteCharAt(s.length() - 1);
            }
        }

        return answer;
    }
}
