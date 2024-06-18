import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        Deque<String> stack = new ArrayDeque<>();

        for (String str : s.split(" ")) {
            if (!str.isBlank()) {
                stack.addFirst(str);
            }
        }

        return String.join(" ", stack);
    }
}
