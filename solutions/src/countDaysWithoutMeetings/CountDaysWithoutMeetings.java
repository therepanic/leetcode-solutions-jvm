package countDaysWithoutMeetings;

import java.util.Arrays;
import java.util.Comparator;

public class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(p -> p[0]));
        int answer = 0;
        int lastEnd = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > lastEnd + 1) {
                answer += meeting[0] - lastEnd - 1;
            }
            lastEnd = Math.max(lastEnd, meeting[1]);
        }
        answer += days - lastEnd;
        return answer;
    }
}
