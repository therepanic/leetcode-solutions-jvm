package throneInheritance;

import java.util.*;

public class ThroneInheritance {
    private final String king;
    private final Map<String, List<String>> successors;
    private final Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.successors = new HashMap<>(Map.of(kingName, new ArrayList<>()));
        this.dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        successors.computeIfAbsent(parentName, f -> new ArrayList<>()).add(childName);
        successors.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        helper(king, inheritanceOrder, dead);
        return inheritanceOrder;
    }
    private void helper(String node, List<String> inheritanceOrder, Set<String> dead) {
        if (!dead.contains(node)) {
            inheritanceOrder.add(node);
        }
        for (String curNode : successors.getOrDefault(node, Collections.emptyList())) {
            helper(curNode, inheritanceOrder, dead);
        }
    }
}
