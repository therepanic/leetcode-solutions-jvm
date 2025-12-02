package checkIfAStringCanBreakAnotherString;

public class CheckIfAStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] first = new int[26];
        int[] second = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            first[s1.charAt(i) - 'a']++;
            second[s2.charAt(i) - 'a']++;
        }
        boolean firstOk = true;
        boolean secondOk = true;
        int point = 0;
        for (int i = 0; i < 26; i++) {
            point += first[i] - second[i];
            if (point < 0) {
                firstOk = false;
                break;
            }
        }
        point = 0;
        for (int i = 0; i < 26; i++) {
            point += second[i] - first[i];
            if (point < 0) {
                secondOk = false;
                break;
            }
        }
        return firstOk || secondOk;
    }
}
