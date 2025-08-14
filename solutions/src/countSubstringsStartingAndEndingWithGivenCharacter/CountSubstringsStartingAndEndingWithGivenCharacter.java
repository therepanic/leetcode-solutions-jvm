package countSubstringsStartingAndEndingWithGivenCharacter;

public class CountSubstringsStartingAndEndingWithGivenCharacter {

    public long countSubstrings(String s, char c) {
        long allCount = 0;
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
                allCount += count;
            }
        }
        return allCount;
    }

}
