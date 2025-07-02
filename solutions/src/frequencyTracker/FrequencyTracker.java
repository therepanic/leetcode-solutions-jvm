package frequencyTracker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyTracker {

    private final Map<Integer, Set<Integer>> def;
    private final Map<Integer, Integer> rev;

    public FrequencyTracker() {
        this.def = new HashMap<>();
        this.rev = new HashMap<>();
    }

    public void add(int number) {
        int freq = rev.getOrDefault(number, -1);
        if (freq == -1) {
            rev.put(number, 1);
            def.computeIfAbsent(1, p -> new HashSet<>()).add(number);
        } else {
            def.get(freq).remove(number);
            freq++;
            rev.put(number, freq);
            def.computeIfAbsent(freq, p -> new HashSet<>()).add(number);
        }
    }

    public void deleteOne(int number) {
        if (rev.containsKey(number)) {
            int freq = rev.get(number);
            def.get(freq).remove(number);
            rev.remove(number);
            freq--;
            rev.put(number, freq);
            def.computeIfAbsent(freq, p -> new HashSet<>()).add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        return def.containsKey(frequency) && !def.get(frequency).isEmpty();
    }

}
