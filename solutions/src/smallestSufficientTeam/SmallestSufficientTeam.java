package smallestSufficientTeam;

import java.util.*;

public class SmallestSufficientTeam {

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillBitMap = new HashMap<>();
        int bitCount = 0;
        for (String skill : req_skills) {
            skillBitMap.put(skill, bitCount);
            bitCount++;
        }
        int[] peopleMasks = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            List<String> person = people.get(i);
            int mask = 0;
            for (String skill : person) {
                if (skillBitMap.containsKey(skill)) {
                    mask |= (1 << skillBitMap.get(skill));
                }
            }
            peopleMasks[i] = mask;
        }
        int full = (1 << req_skills.length) - 1;
        List<Integer>[] dp = new ArrayList[1 << req_skills.length];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < peopleMasks.length; i++) {
            int tempMask = peopleMasks[i];
            for (int mask = full; mask >= 0; mask--) {
                if (dp[mask] == null) continue;
                int newMask = mask | tempMask;
                if (dp[newMask] == null || dp[newMask].size() > dp[mask].size() + 1) {
                    List<Integer> newTeam = new ArrayList<>(dp[mask]);
                    newTeam.add(i);
                    dp[newMask] = newTeam;
                }
            }
        }
        return convertListToIntArray(dp[dp.length - 1]);
    }

    public static int[] convertListToIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
