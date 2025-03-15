package designSpreadsheet;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {
    private final Map<String, Integer> spreadSheetMap;

    public Spreadsheet(int rows) {
        this.spreadSheetMap = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        spreadSheetMap.put(cell, value);
    }

    public void resetCell(String cell) {
        spreadSheetMap.remove(cell);
    }

    public int getValue(String formula) {
        String regex = "=([A-Za-z]+\\d+|\\d+)\\+([A-Za-z]+\\d+|\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formula);
        if (matcher.find()) {
            String first = matcher.group(1);
            String second = matcher.group(2);
            Integer f = null;
            Integer s = null;
            try {
                f = Integer.parseInt(first);
            } catch (Exception e) {}
            try {
                s = Integer.parseInt(second);
            } catch (Exception e) {}
            if (f == null && s == null) {
                return spreadSheetMap.getOrDefault(first, 0) +
                        spreadSheetMap.getOrDefault(second, 0);
            } else if (f == null) {
                return spreadSheetMap.getOrDefault(first, 0) +
                        s;
            } else if (s == null) {
                return f +
                        spreadSheetMap.getOrDefault(second, 0);
            } else {
                return f + s;
            }
        } else {
            return -1;
        }
    }
}
