package maximumNumberOfVowelsInASubstringOfGivenLength;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        char[] sChars = s.toCharArray();
        int maxVowelCount = 0;
        int vowelsCount = 0;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if (sChars[r] == 'a' || sChars[r] == 'e' || sChars[r] == 'i' || sChars[r] == 'o' || sChars[r] == 'u') {
                vowelsCount++;
            }

            while (r - l + 1 > k) {
                if (sChars[l] == 'a' || sChars[l] == 'e' || sChars[l] == 'i' || sChars[l] == 'o' || sChars[l] == 'u') {
                    vowelsCount--;
                }

                l++;
            }

            if (r - l + 1 == k) {
                maxVowelCount = Math.max(maxVowelCount, vowelsCount);
            }
        }

        return maxVowelCount;
    }
}
