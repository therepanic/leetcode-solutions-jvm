package findLongestSpecialSubstringThatOccursThriceI;

public class FindLongestSpecialSubstringThatOccursThriceI {
    public int maximumLength(String s) {
        int l = 1;
        int r = s.length();

        if (!helper(s, l)) {
            return -1;
        }

        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (helper(s, mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public boolean helper(String s, int mid) {
        int[] count = new int[26];

        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            while (s.charAt(l) != s.charAt(r)) {
                l++;
            }

            char rChar = s.charAt(r);

            if (r - l + 1 >= mid) {
                count[rChar - 'a']++;
            }

            if (count[rChar - 'a'] > 2) return true;
        }

        return false;
    }
}
