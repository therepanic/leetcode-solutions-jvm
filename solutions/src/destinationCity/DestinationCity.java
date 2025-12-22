package destinationCity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> checked = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            checked.add(paths.get(i).getFirst());
        }
        for (int i = 0; i < paths.size(); i++) {
            String val = paths.get(i).get(1);
            if (!checked.contains(val)) {
                return val;
            }
        }
        return null;
    }
}
