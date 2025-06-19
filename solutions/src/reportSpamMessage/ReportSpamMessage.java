package reportSpamMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReportSpamMessage {

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = new HashSet<>(Arrays.asList(bannedWords));
        int c = 0;
        for (String word : message) {
            if (banned.contains(word)) {
                c++;
                if (c == 2) {
                    return true;
                }
            }
        }
        return false;
    }

}
