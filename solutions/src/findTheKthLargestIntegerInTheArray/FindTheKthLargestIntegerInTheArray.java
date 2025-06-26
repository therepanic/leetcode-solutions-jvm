package findTheKthLargestIntegerInTheArray;

import java.util.PriorityQueue;

public class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> heap = new PriorityQueue<>((p1, p2) -> p1.length() != p2.length() ? p1.length() - p2.length() : p1.compareTo(p2));
        for (String num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
