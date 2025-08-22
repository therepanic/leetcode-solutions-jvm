package excelSheetColumnNumber;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans = ans * 26 + (Character.toLowerCase(columnTitle.charAt(i)) - 'a' + 1);
        }
        return ans;
    }
}
