package minimumNumberOfStepsToMakeTwoStringsAnagram;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        for (int i = 0; i < n; i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (sChars[i] > 0 && tChars[i] < sChars[i]) {
                c += sChars[i] - tChars[i];
            }
        }
        return c;
    }
}
