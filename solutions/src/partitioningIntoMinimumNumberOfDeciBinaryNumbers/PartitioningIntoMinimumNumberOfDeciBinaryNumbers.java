package partitioningIntoMinimumNumberOfDeciBinaryNumbers;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public int minPartitions(String n) {
        int v = -1;
        for (int i = 0; i < n.length(); i++) {
            v = Math.max(v, n.charAt(i) - '0');
            if (v == 9) return 9;
        }
        return v;
    }
}
