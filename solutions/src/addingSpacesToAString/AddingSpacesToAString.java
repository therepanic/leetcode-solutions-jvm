package addingSpacesToAString;

public class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        char[] sChars = s.toCharArray();
        char[] chars = new char[s.length() + spaces.length];

        int spaceIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            if (spaceIndex < spaces.length && i - spaceIndex == spaces[spaceIndex]) {
                chars[i] = ' ';
                spaceIndex++;
                continue;
            }

            chars[i] = sChars[i - spaceIndex];
        }

        return String.valueOf(chars);
    }
}
