package countAndSay;

public class CountAndSay {
    public String countAndSay(int n) {
        char[] answer = new char[] {'1'};
        StringBuilder newSb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            int c = 1;
            char last = answer[0];
            for (int j = 1; j < answer.length; j++) {
                if (answer[j] != last) {
                    newSb.append(c).append(last);
                    c = 1;
                    last = answer[j];
                } else {
                    c++;
                }
            }
            newSb.append(c).append(last);
            answer = newSb.toString().toCharArray();
            newSb.setLength(0);
        }
        return String.valueOf(answer);
    }
}
