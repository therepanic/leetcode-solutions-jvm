package numberOfSubstringsContainingAllThreeCharacters;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static int numberOfSubstrings(String s) {
        int a = 0;
        int b = 0;
        int c = 0;

        int l = 0;

        int answer = 0;

        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == 'a') {
                a++;
            } else if (s.charAt(r) == 'b') {
                b++;
            } else if (s.charAt(r) == 'c') {
                c++;
            }

            while (a >= 1 && b >= 1 && c >= 1) {
                answer += s.length() - r;

                if (s.charAt(l) == 'a') {
                    a--;
                } else if (s.charAt(l) == 'b') {
                    b--;
                } else if (s.charAt(l) == 'c') {
                    c--;
                }

                l++;
            }
        }
        return answer;
    }
}
