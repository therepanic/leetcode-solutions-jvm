package minimumDeletionsToMakeStringBalanced;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                answer = Math.min(answer + 1, bCount);
            } else {
                bCount++;
            }
        }
        return answer;
    }
}
