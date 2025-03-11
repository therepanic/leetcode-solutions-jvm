package vowelsOfAllSubstrings;

public class VowelsOfAllSubstrings {
    public long countVowels(String word) {
        char[] wordChars = word.toCharArray();
        long c = 0;
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == 'a' || wordChars[i] == 'e' || wordChars[i] == 'i' || wordChars[i] == 'o' || wordChars[i] == 'u') {
                c += ((long) i + 1) * (wordChars.length - i);
            }
        }
        return c;
    }
}
