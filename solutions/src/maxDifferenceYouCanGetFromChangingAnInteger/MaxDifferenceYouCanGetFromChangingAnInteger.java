package maxDifferenceYouCanGetFromChangingAnInteger;

public class MaxDifferenceYouCanGetFromChangingAnInteger {

    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        StringBuilder max = new StringBuilder(numStr);
        StringBuilder min = new StringBuilder(numStr);
        for (int i = 0; i < max.length(); i++) {
            char ch = max.charAt(i);
            if (ch != '9') {
                replace(i, ch, '9', max);
                break;
            }
        }
        for (int i = 0; i < min.length(); i++) {
            char ch = min.charAt(i);
            if (i == 0) {
                if (ch != '1') {
                    replace(i, ch, '1', min);
                    break;
                }
            } else {
                if (ch != '0' && ch != min.charAt(0)) {
                    replace(i, ch, '0', min);
                    break;
                }
            }
        }
        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
    }

    public void replace(int it, char chFirst, char chSecond, StringBuilder sb) {
        for (int i = it; i < sb.length(); i++) {
            if (sb.charAt(i) == chFirst) {
                sb.setCharAt(i, chSecond);
            }
        }
    }

}
