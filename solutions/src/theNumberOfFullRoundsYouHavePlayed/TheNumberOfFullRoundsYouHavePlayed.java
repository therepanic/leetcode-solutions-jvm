package theNumberOfFullRoundsYouHavePlayed;

public class TheNumberOfFullRoundsYouHavePlayed {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int a = 0;
        int b = 0;
        int aMin = 0;
        int bMin = 0;
        boolean signal = false;
        for (int i = 0; i < loginTime.length(); i++) {
            char ch = loginTime.charAt(i);
            if (ch == ':') {
                signal = true;
                continue;
            }
            int dig = Character.digit(ch, 10);
            if (!signal) {
                a *= 10;
                a += dig;
            } else {
                aMin *= 10;
                aMin += dig;
            }
        }
        signal = false;
        for (int i = 0; i < logoutTime.length(); i++) {
            char ch = logoutTime.charAt(i);
            if (ch == ':') {
                signal = true;
                continue;
            }
            int dig = Character.digit(ch, 10);
            if (!signal) {
                b *= 10;
                b += dig;
            } else {
                bMin *= 10;
                bMin += dig;
            }
        }
        aMin += a * 60;
        bMin += b * 60;
        boolean lower = aMin < bMin;
        while (aMin % 15 != 0) {
            aMin++;
        }
        if (lower && aMin >= bMin) return 0;
        if (bMin > aMin) {
            return (bMin - aMin) / 15;
        } else {
            int first = (1440 - aMin) / 15;
            return (bMin / 15) + first;
        }
    }
}
