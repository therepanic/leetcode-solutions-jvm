package allOoneDataStructure;

import java.util.*;

public class AllOne {

    private Bucket root;
    private Bucket last;

    private Map<String, Bucket> buckets = new HashMap<>();

    static class Bucket {
        int count;
        Set<String> keys;
        Bucket prev;
        Bucket next;

        public Bucket(int count, Set<String> keys, Bucket prev, Bucket next) {
            this.count = count;
            this.keys = keys;
            this.prev = prev;
            this.next = next;
        }
    }


    public AllOne() {
    }

    public void inc(String key) {
        if (!this.buckets.containsKey(key)) {
            if (this.root == null) {
                this.root = new Bucket(1, new HashSet<>(), null, null);
                this.last = this.root;
            } else if (this.root.count != 1) {
                Bucket n = new Bucket(1, new HashSet<>(), null, this.root);
                this.root.prev = n;
                this.root = n;
            }
            this.root.keys.add(key);
            this.buckets.put(key, this.root);
        } else {
            Bucket cur = this.buckets.get(key);
            cur.keys.remove(key);
            if (cur.next == null || cur.next.count != cur.count + 1) {
                if (cur.next == null) {
                    cur.next = new Bucket(cur.count + 1, new HashSet<>(), cur, null);
                    this.last = cur.next;
                } else {
                    Bucket n = new Bucket(cur.count + 1, new HashSet<>(), cur, cur.next);
                    cur.next.prev = n;
                    cur.next = n;
                }
            }
            Bucket next = cur.next;
            next.keys.add(key);
            this.buckets.put(key, next);
            if (cur.keys.isEmpty()) {
                removeBucket(cur);
            }
        }
    }

    public void dec(String key) {
        Bucket cur = buckets.get(key);
        cur.keys.remove(key);

        if (cur.count == 1) {
            buckets.remove(key);
        } else {
            Bucket prev;
            if (cur.prev != null && cur.prev.count == cur.count - 1) {
                prev = cur.prev;
            } else {
                prev = new Bucket(cur.count - 1, new HashSet<>(), cur.prev, cur);
                if (cur.prev == null) {
                    root = prev;
                } else {
                    cur.prev.next = prev;
                }
                cur.prev = prev;
            }
            prev.keys.add(key);
            buckets.put(key, prev);
        }
        if (cur.keys.isEmpty()) {
            removeBucket(cur);
        }
    }

    private void removeBucket(Bucket cur) {
        if (cur.prev == null) {
            root = cur.next;
        } else {
            cur.prev.next = cur.next;
        }
        if (cur.next == null) {
            last = cur.prev;
        } else {
            cur.next.prev = cur.prev;
        }
    }

    public String getMaxKey() {
        if (this.last == null || this.last.keys.isEmpty()) {
            return "";
        }
        return this.last.keys.iterator().next();
    }

    public String getMinKey() {
        if (this.root == null || this.root.keys.isEmpty()) {
            return "";
        }
        return this.root.keys.iterator().next();
    }
}
