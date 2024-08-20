package palindromePartitioningII;

public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
    public static int minCut(String s) {
        //todo
        return 0;
    }

    public static boolean isPalindrome(String word) {
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length / 2; i++) {
            if (wordChars[i] != wordChars[wordChars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
