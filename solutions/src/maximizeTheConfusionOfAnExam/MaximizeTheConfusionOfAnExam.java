package maximizeTheConfusionOfAnExam;

import java.util.HashMap;
import java.util.Map;

public class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character, Integer> characterCountMap = new HashMap<>(Map.of('T', 0, 'F', 0));
        char[] answerKeyChars = answerKey.toCharArray();
        int l = 0;

        int longestStreak = 0;

        for (int r = 0; r < answerKeyChars.length; r++) {
            characterCountMap.put(answerKeyChars[r], characterCountMap.get(answerKeyChars[r]) + 1);

            int windowLength = r - l + 1;
            int charWithMostCount = 0;

            for (int value : characterCountMap.values()) {
                charWithMostCount = Math.max(charWithMostCount, value);
            }

            if (windowLength - charWithMostCount <= k) {
                for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
                    if (entry.getValue() > charWithMostCount) {
                        charWithMostCount = entry.getValue();
                    }
                }
            } else {
                while (windowLength - charWithMostCount > k) {
                    characterCountMap.put(answerKeyChars[l], characterCountMap.get(answerKeyChars[l]) - 1);

                    for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
                        if (entry.getValue() > charWithMostCount) {
                            charWithMostCount = entry.getValue();
                        }
                    }
                    l++;
                    windowLength = r - l + 1;
                }
            }


            longestStreak = Math.max(longestStreak, windowLength);
        }

        return longestStreak;
    }
}
