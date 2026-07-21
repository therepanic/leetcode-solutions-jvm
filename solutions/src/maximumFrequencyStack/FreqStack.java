package maximumFrequencyStack;

import java.util.*;

public class FreqStack {

    private final Map<Integer, Integer> valFrequencies = new HashMap<>();

    private final Map<Integer, List<Integer>> freqValues = new HashMap<>();

    private int maxFreq = 0;

    public FreqStack() {
    }

    public void push(int val) {
        int freq = this.valFrequencies.getOrDefault(val, 0) + 1;
        this.valFrequencies.put(val, freq);
        this.maxFreq = Math.max(this.maxFreq, freq);
        this.freqValues.computeIfAbsent(freq, _ -> new ArrayList<>()).add(val);
    }

    public int pop() {
        int v = this.freqValues.get(this.maxFreq).removeLast();
        this.valFrequencies.put(v, this.maxFreq - 1);
        if (this.freqValues.get(this.maxFreq).isEmpty()) {
            this.maxFreq--;
        }
        return v;
    }
}
