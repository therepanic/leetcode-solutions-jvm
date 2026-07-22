package designSQL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQL {

    private final Map<String, Integer> columns = new HashMap<>();

    private final Map<String, List<List<String>>> rows = new HashMap<>();

    public SQL(List<String> names, List<Integer> columns) {
        for (int i = 0; i < names.size(); i++) {
            this.columns.put(names.get(i), columns.get(i));
        }
    }

    public boolean ins(String name, List<String> row) {
        if (!this.columns.containsKey(name)) {
            return false;
        }
        if (this.columns.get(name) != row.size()) {
            return false;
        }
        this.rows.computeIfAbsent(name, _ -> new ArrayList<>()).add(row);
        return true;
    }

    public void rmv(String name, int rowId) {
        List<List<String>> table = this.rows.get(name);
        if (table != null && rowId >= 1 && rowId <= table.size()) {
            table.set(rowId - 1, null);
        }
    }

    public String sel(String name, int rowId, int columnId) {
        List<List<String>> table = this.rows.get(name);
        if (table == null || rowId < 1 || rowId > table.size() || columnId < 1 || columnId > this.columns.get(name)) {
            return "<null>";
        }
        List<String> row = table.get(rowId - 1);
        if (row == null) {
            return "<null>";
        }
        return row.get(columnId - 1);
    }

    public List<String> exp(String name) {
        List<String> result = new ArrayList<>();
        List<List<String>> table = this.rows.get(name);
        if (table == null) {
            return result;
        }
        for (int i = 0; i < table.size(); i++) {
            List<String> row = table.get(i);
            if (row == null) {
                continue;
            }
            result.add((i + 1) + "," + String.join(",", row));
        }
        return result;
    }

}
