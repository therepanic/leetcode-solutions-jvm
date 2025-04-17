package countBeautifulSubstringsI;

public class CountBeautifulSubstringsI {
    public int beautifulSubstrings(String s, int k) {
        char[] sChars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int vowels = 0;
            int constants = 0;
            for (int j = i; j < s.length(); j++) {
                if (sChars[j] == 'a' || sChars[j] == 'e' || sChars[j] == 'i' || sChars[j] == 'o' || sChars[j] == 'u') {
                    vowels++;
                } else {
                    constants++;
                }
                if (vowels == constants && (vowels * constants) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
