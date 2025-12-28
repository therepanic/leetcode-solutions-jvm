package breakAPalindrome;

public class BreakAPalindrome {

    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] palindromeChars = palindrome.toCharArray();
        for (int i = 0; i < palindromeChars.length / 2; i++) {
            if (palindromeChars[i] != 'a') {
                char[] copied = palindromeChars.clone();
                copied[i] = 'a';
                return String.valueOf(copied);
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + "b";
    }

}
