package deleteCharactersToMakeFancyString;

public class DeleteCharactersToMakeFancyString {
    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        char ch = s.charAt(0);
        int count = 0;

        for (char c : s.toCharArray()) {
            if (ch == c) {
                count++;

                if (count >= 3) {
                    continue;
                }

                sb.append(c);
            } else {
                ch = c;
                count = 1;

                sb.append(c);
            }
        }

        return sb.toString();
    }
}
