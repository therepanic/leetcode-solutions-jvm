package rescheduleMeetingsForMaximumFreeTimeI;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsForMaximumFreeTimeI {

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> gaps = new ArrayList<>();
        gaps.add(startTime[0]);
        for (int i = 1; i < endTime.length; i++) {
            int val = startTime[i] - endTime[i - 1];
            gaps.add(val);
        }
        gaps.add(eventTime - endTime[endTime.length - 1]);
        int windowSize = k + 1;
        int l = 0;
        int answer = 0;
        int sum = 0;
        for (int r = 0; r < gaps.size(); r++) {
            sum += gaps.get(r);
            if (r - l + 1 > windowSize) {
                sum -= gaps.get(l);
                l++;
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

}
