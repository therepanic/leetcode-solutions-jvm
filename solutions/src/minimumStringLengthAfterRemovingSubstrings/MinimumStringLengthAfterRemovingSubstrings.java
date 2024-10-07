package minimumStringLengthAfterRemovingSubstrings;

public class MinimumStringLengthAfterRemovingSubstrings {
    public static int minLength(String s) {
        if (s.contains("AB")) {
            s = s.replaceAll("AB", "");

            return minLength(s);
        } else if (s.contains("CD")) {
            s = s.replaceAll("CD", "");

            return minLength(s);
        } else {
            return s.length();
        }
    }
}
