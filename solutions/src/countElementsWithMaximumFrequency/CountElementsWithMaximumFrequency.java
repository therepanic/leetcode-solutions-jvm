package countElementsWithMaximumFrequency;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int c = 0;
        int maxFreq = 0;
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            if (freq > maxFreq) {
                c = freq;
                maxFreq = freq;
            } else if (freq == maxFreq) {
                c += freq;
            }
            freqMap.put(num, freq);
        }
        return c;
    }
}
