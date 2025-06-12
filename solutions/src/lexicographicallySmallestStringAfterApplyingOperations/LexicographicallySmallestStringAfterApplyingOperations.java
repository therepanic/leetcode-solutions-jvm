package lexicographicallySmallestStringAfterApplyingOperations;

import java.util.TreeSet;

public class LexicographicallySmallestStringAfterApplyingOperations {

    public static String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> values = new TreeSet<>();
        helper(s, a, b, values);
        return values.getFirst();
    }

    public static void helper(String s, int a, int b, TreeSet<String> values) {
        String aStr = rotate(s, b);
        String bStr = add(s, a);
        if (!values.contains(aStr)) {
            values.add(aStr);
            helper(aStr, a, b, values);
        }
        if (!values.contains(bStr)) {
            values.add(bStr);
            helper(bStr, a, b, values);
        }
    }

    public static String rotate(String s, int b) {
        StringBuilder newStr = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            newStr.setCharAt((i + b) % s.length(), s.charAt(i));
        }
        return newStr.toString();
    }

    public static String add(String s, int a) {
        StringBuilder newStr = new StringBuilder(s);
        for (int i = 1; i < s.length(); i += 2) {
            newStr.setCharAt(i, Character.forDigit(((s.charAt(i) - '0') + a) % 10, 10));
        }
        return newStr.toString();
    }

}
