package maximumBitwiseXORAfterRearrangement;

public class MaximumBitwiseXORAfterRearrangement {
    public String maximumXor(String s, String t) {
        int oneCount = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '1') {
                oneCount++;
            }
        }
        char[] schars = s.toCharArray();
        boolean[] yeah = new boolean[t.length()];
        for (int i = 0; i < schars.length && oneCount > 0; i++) {
            if (schars[i] == '0') {
                schars[i] = '1';
                oneCount--;
                yeah[i] = true;
            }
        }
        for (int i = schars.length - 1; i >= 0 && oneCount > 0; i--) {
            if (!yeah[i] && schars[i] == '1') {
                schars[i] = '0';
                oneCount--;
            }
        }
        return new String(schars);
    }
}
