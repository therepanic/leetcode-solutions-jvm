package mergeCloseCharacters;

public class MergeCloseCharacters {
    public static String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean merged = false;
            for (int i = 0; i < sb.length(); i++) {
                int limit = Math.min(sb.length() - 1, i + k);
                for (int j = i + 1; j <= limit; j++) {
                    if (sb.charAt(i) == sb.charAt(j)) {
                        sb.deleteCharAt(j);
                        merged = true;
                        break;
                    }
                }
                if (merged) {
                    break;
                }
            }

            if (!merged) {
                break;
            }
        }

        return sb.toString();
    }
}
