package reorderDataInLogFiles;

import java.util.*;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (p1, p2) -> {
            int firstSpace = p1.indexOf(' ');
            int secondSpace = p2.indexOf(' ');
            String fromFirst = p1.substring(0, firstSpace);
            String fromSecond = p2.substring(0, secondSpace);
            String toFirst = p1.substring(firstSpace + 1);
            String toSecond = p2.substring(secondSpace + 1);
            boolean isFirstDigit = Character.isDigit(toFirst.charAt(0));
            boolean isSecondDigit = Character.isDigit(toSecond.charAt(0));
            if (!isFirstDigit && !isSecondDigit) {
                int comp = toFirst.compareTo(toSecond);
                return comp == 0 ? fromFirst.compareTo(fromSecond) : comp;
            } else if (!isFirstDigit) {
                return -1;
            } else if (!isSecondDigit) {
                return 1;
            }
            return 0;
        });
        return logs;
    }
}
