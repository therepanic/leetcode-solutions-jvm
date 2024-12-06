package camelcaseMatching;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> matching = new ArrayList<>();
        char[] patternChars = pattern.toCharArray();

        for (String query : queries) {
            char[] queryChars = query.toCharArray();

            int j = 0;

            boolean isOk = true;
            for (char c : queryChars) {

                if (j < patternChars.length && c == patternChars[j]) {
                    j++;
                } else {
                    if (Character.isUpperCase(c)) {
                        isOk = false;
                        break;
                    }
                }
            }

            if (j < patternChars.length) {
                isOk = false;
            }

            matching.add(isOk);
        }

        return matching;
    }
}
