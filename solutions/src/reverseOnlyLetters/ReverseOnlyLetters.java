package reverseOnlyLetters;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetter(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetter(s.charAt(r))) {
                r--;
            }
            char a = chars[l];
            chars[l] = chars[r];
            chars[r] = a;
            l++;
            r--;
        }
        return String.valueOf(chars);
    }
}
