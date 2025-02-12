package findTheWinnerOfAnArrayGame;

import java.util.LinkedList;

public class FindTheWinnerOfAnArrayGame {
    public static int getWinner(int[] arr, int k) {
        k = Math.min(k, arr.length);
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(arr[i]);
        }
        int lastW = 0;
        int countLastW = 0;
        while (countLastW != k) {
            if (linkedList.getFirst() > linkedList.get(1)) {
                int n = linkedList.get(1);
                linkedList.remove(1);
                linkedList.add(n);
                if (lastW == linkedList.getFirst()) {
                    countLastW++;
                } else {
                    lastW = linkedList.getFirst();
                    countLastW = 1;
                }
            } else {
                int n = linkedList.getFirst();
                linkedList.removeFirst();
                linkedList.add(n);
                if (lastW == linkedList.getFirst()) {
                    countLastW++;
                } else {
                    lastW = linkedList.getFirst();
                    countLastW = 1;
                }
            }
        }
        return lastW;
    }
}
