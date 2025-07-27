package sortTheJumbledNumbers;

import java.util.*;

public class SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> mappingMap = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            mappingMap.put(i, mapping[i]);
        }
        List<int[]> itNums = new ArrayList<>();
        for (int num : nums) {
            char[] chs = String.valueOf(num).toCharArray();
            int val = 0;
            for (char ch : chs) {
                val *= 10;
                val += mappingMap.get(Character.digit(ch, 10));
            }
            itNums.add(new int[] {num, val});
        }
        itNums.sort(Comparator.comparingInt(p -> p[1]));
        int[] answer = new int[nums.length];
        for (int i = 0; i < itNums.size(); i++) {
            answer[i] = itNums.get(i)[0];
        }
        return answer;
    }
}
