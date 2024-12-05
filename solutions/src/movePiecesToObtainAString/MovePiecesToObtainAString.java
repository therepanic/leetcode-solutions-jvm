package movePiecesToObtainAString;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MovePiecesToObtainAString {
    public static boolean canChange(String start, String target) {
        String filteredStart = start.replace("_", "");
        String filteredTarget = target.replace("_", "");

        if (!filteredTarget.equals(filteredStart)) return false;

        int it = 0;

        for (int i = 0 ; i < start.length(); i++) {
            if (start.charAt(i) == '_') continue;


            while (target.charAt(it) == '_') it++;

            if (start.charAt(i) == 'L' && i < it || start.charAt(i) == 'R' && i > it) {
                return false;
            }

            it++;
        }

        return true;
    }

}
