package decodeString;

public class DecodeString {

    public static String decodeString(String s) {
        String ans = decode(0, s.toCharArray()).second;
        return ans;
    }

    public static Entry<Integer, String> decode(int it, char[] chars) {
        int v = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = it; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                v *= 10;
                v += chars[i] - '0';
            } else if (chars[i] == '[') {
                var entry = decode(i + 1, chars);
                sb.append(entry.second.repeat(v));
                i = entry.first;
                v = 0;
            } else if (chars[i] == ']') {
                return new Entry<>(i, v == 0 ? sb.toString() : sb.toString().repeat(v));
            } else {
                sb.append(chars[i]);
            }
        }
        return new Entry<>(-1, v == 0 ? sb.toString() : sb.toString().repeat(v));
    }

    static class Entry<T, L> {
        private T first;
        private L second;

        public Entry(T first, L second) {
            this.first = first;
            this.second = second;
        }

    }
}
