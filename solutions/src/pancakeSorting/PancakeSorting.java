package pancakeSorting;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int index = 0;
            while (arr[index] != i) {
                index++;
            }
            ans.add(index + 1); reverse(arr, index + 1);
            ans.add(i); reverse(arr, i);
        }
        return ans;
    }

    public void reverse(int[] arr, int k) {
        for (int i = 0; i < k / 2; i++) {
            int a = arr[i];
            arr[i] = arr[k - i - 1];
            arr[k - i - 1] = a;
        }
    }
}
