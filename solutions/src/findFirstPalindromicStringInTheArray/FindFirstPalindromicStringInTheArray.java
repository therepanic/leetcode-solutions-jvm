package findFirstPalindromicStringInTheArray;

public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (palindrome(words[i])) {
                return words[i];
            }
        }
        return "";
    }

    public boolean palindrome(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
