package maximumBinaryStringAfterChange;

public class MaximumBinaryStringAfterChange {
    public String maximumBinaryString(String binary) {
        StringBuilder ans = new StringBuilder();
        char[] ch = binary.toCharArray();
        int one = 0;
        int zero = 0;
        int i;
        for (i = 0; i < binary.length() && ch[i] == '1'; i++) {
            ans.append("1");
        }
        for (; i < binary.length(); i++) {
            if (ch[i] == '1') {
                one++;
            } else {
                zero++;
            }
        }
        ans.append("0".repeat(zero));
        ans.append("1".repeat(one));
        for (i = 0; i < ans.length() - 1; i++) {
            if (ans.charAt(i) == '0' && ans.charAt(i + 1) == '0') {
                ans.setCharAt(i, '1');
            }
        }
        return ans.toString();
    }
}
