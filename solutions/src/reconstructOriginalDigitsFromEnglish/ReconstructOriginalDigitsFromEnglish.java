package reconstructOriginalDigitsFromEnglish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] count = new int[26];
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            count[c - 'a']++;
        }
        List<Integer> nums = new ArrayList<>();
        while (count['z' - 'a'] > 0) {
            count['z' - 'a']--;
            count['e' - 'a']--;
            count['r' - 'a']--;
            count['o' - 'a']--;
            nums.add(0);
        }
        while (count['w' - 'a'] > 0) {
            count['t' - 'a']--;
            count['w' - 'a']--;
            count['o' - 'a']--;
            nums.add(2);
        }
        while (count['u' - 'a'] > 0) {
            count['f' - 'a']--;
            count['o' - 'a']--;
            count['u' - 'a']--;
            count['r' - 'a']--;
            nums.add(4);
        }
        while (count['x' - 'a'] > 0) {
            count['s' - 'a']--;
            count['i' - 'a']--;
            count['x' - 'a']--;
            nums.add(6);
        }
        while (count['g' - 'a'] > 0) {
            count['e' - 'a']--;
            count['i' - 'a']--;
            count['g' - 'a']--;
            count['h' - 'a']--;
            count['t' - 'a']--;
            nums.add(8);
        }
        while (count['o' - 'a'] > 0) {
            count['o' - 'a']--;
            count['n' - 'a']--;
            count['e' - 'a']--;
            nums.add(1);
        }
        while (count['r' - 'a'] > 0) {
            count['t' - 'a']--;
            count['h' - 'a']--;
            count['r' - 'a']--;
            count['e' - 'a']--;
            count['e' - 'a']--;
            nums.add(3);
        }
        while (count['f' - 'a'] > 0) {
            count['f' - 'a']--;
            count['i' - 'a']--;
            count['v' - 'a']--;
            count['e' - 'a']--;
            nums.add(5);
        }
        while (count['s' - 'a'] > 0) {
            count['s' - 'a']--;
            count['e' - 'a']--;
            count['v' - 'a']--;
            count['e' - 'a']--;
            count['n' - 'a']--;
            nums.add(7);
        }
        while (count['n' - 'a'] > 0) {
            count['n' - 'a']--;
            count['i' - 'a']--;
            count['n' - 'a']--;
            count['e' - 'a']--;
            nums.add(9);
        }
        Collections.sort(nums);
        StringBuilder ans = new StringBuilder();
        for (int val : nums) {
            ans.append(val);
        }
        return ans.toString();
    }
}
