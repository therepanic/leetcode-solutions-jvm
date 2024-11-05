package minimumNumberOfChangesToMakeBinaryStringBeautiful;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int min = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i += 2) {
            char first = chars[i];
            char second = chars[i + 1];

            if (first != second) {
                min++;
            }
        }

        return min;
    }
}
