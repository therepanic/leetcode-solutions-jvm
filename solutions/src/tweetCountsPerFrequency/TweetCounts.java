package tweetCountsPerFrequency;

import java.util.*;

public class TweetCounts {

    private final Map<String, List<Integer>> tweetsTimelines;

    public TweetCounts() {
        this.tweetsTimelines = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        this.tweetsTimelines.computeIfAbsent(tweetName, p -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> answer = new ArrayList<>();
        int delta = switch (freq) {
            case "minute" -> 60;
            case "hour" -> 3600;
            case "day" -> 86400;
            default -> throw new IllegalArgumentException();
        };
        for (int i = 0; i <= (endTime - startTime) / delta; i++) {
            answer.add(0);
        }
        List<Integer> times = this.tweetsTimelines.get(tweetName);
        for (int time : times) {
            if (time >= startTime && time <= endTime) {
                int id = (time - startTime) / delta;
                answer.set(id, answer.get(id) + 1);
            }
        }
        return answer;
    }

}
