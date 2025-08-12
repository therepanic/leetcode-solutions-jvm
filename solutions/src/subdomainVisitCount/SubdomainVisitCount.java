package subdomainVisitCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (String domain : cpdomains) {
            String[] split = domain.split(" ");
            String[] split2 = split[1].split("\\.");
            int lengthSum = 0;
            for (String str : split2) {
                String val = split[1].substring(lengthSum);
                countMap.put(val, countMap.getOrDefault(val, 0) + Integer.parseInt(split[0]));
                lengthSum += str.length() + 1;
            }
        }
        for (var entry : countMap.entrySet()) {
            answer.add(entry.getValue() + " " + entry.getKey());
        }
        return answer;
    }
}
