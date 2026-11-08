package findMismatchedSegmentsBetweenTwoStrings;

import java.util.ArrayList;
import java.util.List;

public class FindMismatchedSegmentsBetweenTwoStrings {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                a.append(ch1);
                b.append(ch2);
            } else {
                if (!a.isEmpty()) {
                    ans.add(List.of(a.toString(), b.toString()));
                    a.setLength(0);
                    b.setLength(0);
                }
            }
        }
        if (!a.isEmpty()) {
            ans.add(List.of(a.toString(), b.toString()));
        }
        return ans;
    }
}
