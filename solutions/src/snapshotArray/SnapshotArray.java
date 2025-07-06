package snapshotArray;

import java.util.*;

public class SnapshotArray {

    private final List<TreeMap<Integer, Integer>> maps;
    private int count;

    public SnapshotArray(int length) {
        this.maps = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            this.maps.add(new TreeMap<>());
        }
    }

    public void set(int index, int val) {
        this.maps.get(index).put(this.count, val);
    }

    public int snap() {
        return this.count++;
    }

    public int get(int index, int snap_id) {
        var val = this.maps.get(index).floorEntry(snap_id);
        return val == null ? 0 : val.getValue();
    }

}
