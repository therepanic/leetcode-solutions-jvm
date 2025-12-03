package changeMinimumCharactersToSatisfyOneOfThreeConditions;

public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {
    public int minCharacters(String a, String b) {
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            count2[b.charAt(i) - 'a']++;
        }
        int c = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            c = Math.min(c, a.length() + b.length() - count1[i] - count2[i]);
            if (i > 0) {
                count1[i] += count1[i - 1];
                count2[i] += count2[i - 1];
            }
            if (i < 25) {
                c = Math.min(c, a.length() - count1[i] + count2[i]);
                c = Math.min(c, b.length() + count1[i] - count2[i]);
            }
        }
        return c;
    }
}
