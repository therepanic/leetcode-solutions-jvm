package maximum69Number;

public class Maximum69Number {

    public int maximum69Number(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(String.valueOf(numChars));
    }

}
