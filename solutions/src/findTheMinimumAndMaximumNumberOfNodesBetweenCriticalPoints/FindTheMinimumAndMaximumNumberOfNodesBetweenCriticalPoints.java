package findTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints;

import structures.listNode.ListNode;

public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        ListNode dummy = head;

        int prevIndex;
        int lowestIndex = Integer.MAX_VALUE;
        int highestIndex = Integer.MAX_VALUE;

        int minimaDistance = Integer.MAX_VALUE;
        int maximaDistance = -1;

        int dummyIndex = 1;
        int numberCount = 0;

        while (dummy.next != null) {
            if (prev != null) {
                if (prev.val < dummy.val && dummy.val > dummy.next.val || prev.val > dummy.val && dummy.val < dummy.next.val) {

                    if (dummyIndex < lowestIndex) {
                        lowestIndex = dummyIndex;
                    }

                    prevIndex = highestIndex;
                    highestIndex = dummyIndex;

                    if (minimaDistance > Math.abs(highestIndex - prevIndex)) {
                        minimaDistance = Math.abs(highestIndex - prevIndex);
                    }

                    numberCount++;
                }
            }

            dummyIndex++;
            prev = dummy;
            dummy = dummy.next;
        }

        if (numberCount < 2) {
            return new int[] {-1, -1};
        }

        if (lowestIndex != Integer.MAX_VALUE) {
            maximaDistance = highestIndex - lowestIndex;
        }

        if (minimaDistance == Integer.MAX_VALUE) {
            minimaDistance = -1;
        }

        return new int[] {minimaDistance, maximaDistance};
    }
}
