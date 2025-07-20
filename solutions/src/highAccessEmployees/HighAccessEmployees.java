package highAccessEmployees;

import java.util.*;

public class HighAccessEmployees {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> employeeMap = new HashMap<>();
        for (var entry : access_times) {
            employeeMap.computeIfAbsent(entry.get(0), p -> new ArrayList<>()).add(Integer.valueOf(entry.get(1)));
        }
        List<String> values = new ArrayList<>();
        for (var entry : employeeMap.entrySet()) {
            Collections.sort(entry.getValue());
            int l = 0;
            int timeInPeriod = entry.getValue().get(0);
            int cInPeriod = 1;
            boolean isThreesOrMode = false;
            for (int r = 1; r < entry.getValue().size(); r++) {
                System.out.println(cInPeriod);
                while (entry.getValue().get(r) - timeInPeriod > 59) {
                    cInPeriod--;
                    l++;
                    timeInPeriod = entry.getValue().get(l);
                }
                if (entry.getValue().get(r) - timeInPeriod <= 59) {
                    cInPeriod++;
                }
                if (cInPeriod >= 3) {
                    isThreesOrMode = true;
                    break;
                }
            }
            if (isThreesOrMode) {
                values.add(entry.getKey());
            }
        }
        return values;
    }
}
