package minimumOperationsToMakeBinaryPalindrome;

public class MinimumOperationsToMakeBinaryPalindrome {
    public int[] minOperations(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!palindrome(Integer.toBinaryString(val))) {
                int up = val - 1;
                int down = val + 1;
                int c = 0;
                while (!palindrome(Integer.toBinaryString(up)) && !palindrome(Integer.toBinaryString(down))) {
                    up--;
                    down++;
                    c++;
                }
                answer[i] = c + 1;
            }
        }
        return answer;
    }

    public boolean palindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
