package minimumNumberOfPushesToTypeWordI;

public class MinimumNumberOfPushesToTypeWordI {
    public int minimumPushes(String word) {
        int s = 0;
        for (int i = 0; i < word.length(); i++) {
            s += (i / 8) + 1;
        }
        return s;
    }
}
