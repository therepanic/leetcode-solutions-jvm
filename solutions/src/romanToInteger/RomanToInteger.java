package romanToInteger;

import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> charIntMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        char[] sChars = s.toCharArray();
        int num = 0;

        for (int i = 0; i < sChars.length - 1; i++) {
            int first = charIntMap.get(sChars[i]);
            int second = charIntMap.get(sChars[i + 1]);
            if (first < second) {
                num -= first;
            } else {
                num += first;
            }
        }
        num += charIntMap.get(sChars[sChars.length - 1]);
        return num;
    }
}
