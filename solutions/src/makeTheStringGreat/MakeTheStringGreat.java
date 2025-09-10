package makeTheStringGreat;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            if (i == -1) continue;
            char a = sb.charAt(i);
            char b = sb.charAt(i + 1);
            if (Character.isUpperCase(a) && Character.isLowerCase(b) && Character.toLowerCase(a) == b
                    || Character.isLowerCase(a) && Character.isUpperCase(b) && Character.toLowerCase(b) == a) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i -= 2;
            }
        }
        return sb.toString();
    }
}
