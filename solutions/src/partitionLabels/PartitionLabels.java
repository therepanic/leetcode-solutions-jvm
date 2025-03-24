package partitionLabels;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        char[] sChars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = sChars[i];
            last[c - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0 ;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[sChars[i] - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = i + 1;
            }
        }
        return partition;
    }
}
