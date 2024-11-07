package senderWithLargestWordCount;

import java.util.*;

public class SenderWithLargestWordCount {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> nameWordCountMap = new HashMap<>();
        String sender = "";
        int maxWordCount = 0;

        for (int i = 0; i < messages.length; i++) {
            int wordCount = messages[i].split(" ").length;

            int count = nameWordCountMap.getOrDefault(senders[i], 0) + wordCount;
            nameWordCountMap.put(senders[i], count);

            if (count > maxWordCount || (count == maxWordCount && senders[i].compareTo(sender) > 0)) {
                maxWordCount = count;
                sender = senders[i];
            }
        }

        return sender;
    }
}
