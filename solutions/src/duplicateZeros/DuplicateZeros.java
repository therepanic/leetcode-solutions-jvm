package duplicateZeros;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new ArrayDeque<>();

        boolean isWorked = true;
        for (int i = 0; i < arr.length; i++) {
            Integer value = queue.peek();

            if (i != 0 && isWorked &&  arr[i - 1] == 0) {
                queue.add(arr[i]);
                arr[i] = 0;

                isWorked = false;

                continue;
            }

            if (value != null) {
                queue.add(arr[i]);

                arr[i] = value;

                queue.remove();
            }

            isWorked = true;
        }
        System.out.println(Arrays.toString(arr));
    }
}
