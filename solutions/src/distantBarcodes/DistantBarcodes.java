package distantBarcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> barcodeMap = new HashMap<>();
        for (int barcode : barcodes) {
            barcodeMap.put(barcode, barcodeMap.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[1], p1[1]));
        for (var entry : barcodeMap.entrySet()) {
            heap.add(new int[] {entry.getKey(), entry.getValue()});
        }
        int[] answer = new int[barcodes.length];
        int it = 0;
        int[] prev = null;
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            poll[1]--;
            answer[it] = poll[0];
            it++;
            if (prev != null && prev[1] != 0) {
                heap.add(prev);
            }
            prev = poll;
        }
        return answer;
    }
}
