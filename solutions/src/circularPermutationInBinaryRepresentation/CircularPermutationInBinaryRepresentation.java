package circularPermutationInBinaryRepresentation;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(start ^ i ^ (i >> 1));
        }
        return ans;
    }
}
