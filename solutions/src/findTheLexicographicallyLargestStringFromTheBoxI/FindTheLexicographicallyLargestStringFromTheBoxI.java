package findTheLexicographicallyLargestStringFromTheBoxI;

public class FindTheLexicographicallyLargestStringFromTheBoxI {
    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int windowSize = word.length() - numFriends + 1;
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            String temp = word.substring(i, Math.min(word.length(), windowSize + i));
            answer = answer.compareTo(temp) >= 0 ? answer : temp;
        }
        return answer;
    }
}
