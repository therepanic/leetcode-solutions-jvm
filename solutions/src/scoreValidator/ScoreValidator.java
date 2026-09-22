package scoreValidator;

public class ScoreValidator {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int count = 0;
        for (int i = 0; i < events.length && count < 10; i++) {
            String e = events[i];
            if (e.equals("W")) {
                count++;
            } else if (e.equals("WD") || e.equals("NB")) {
                score++;
            } else {
                score += Integer.parseInt(e);
            }
        }
        return new int[] {score, count};
    }
}
