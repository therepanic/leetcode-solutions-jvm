package findMirrorScoreOfAString;

import java.util.*;

public class FindMirrorScoreOfAString {
    public static long calculateScore(String s) {
        ArrayDeque<Integer>[] deques = new ArrayDeque[26];
        for (int i = 0; i < deques.length; i++) {
            deques[i] = new ArrayDeque<>();
        }
        char[] sChars = s.toCharArray();
        long answer = 0;
        for (int i = 0; i < sChars.length; i++) {
            char ch = sChars[i];
            int chNum = ch - 'a';
            if (!deques[26 - chNum - 1].isEmpty()) {
                answer += i - deques[26 - chNum - 1].pollLast();
            } else {
                deques[chNum].addLast(i);
            }
        }
        return answer;
    }
}
