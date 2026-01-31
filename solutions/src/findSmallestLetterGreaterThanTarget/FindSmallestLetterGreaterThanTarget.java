package findSmallestLetterGreaterThanTarget;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                max = Math.min(max, letters[i]);
            }
        }
        return (char) (max == Integer.MAX_VALUE ? letters[0] : max);
    }
}
