package generateBinaryStringsWithoutAdjacentZeros;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    public static List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generate("", n, result);
        return result;
    }

    private static void generate(String current, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        generate(current + "1", n, result);
        if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
            generate(current + "0", n, result);
        }
    }
}
