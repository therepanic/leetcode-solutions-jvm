package findPlayersWithZeroOrOneLosses;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> playerLoseCount = new HashMap<>();

        for (int[] match : matches) {
            playerLoseCount.put(match[0], playerLoseCount.getOrDefault(match[0], 0));

            playerLoseCount.put(match[1], playerLoseCount.getOrDefault(match[1], 0) + 1);
        }

        List<List<Integer>> winners = new ArrayList<>();
        winners.add(new ArrayList<>());
        winners.add(new ArrayList<>());

        for (Map.Entry<Integer, Integer> player : playerLoseCount.entrySet()) {
            if (player.getValue() == 0) {
                winners.get(0).add(player.getKey());
            } else if (player.getValue() == 1) {
                winners.get(1).add(player.getKey());
            }
        }

        Collections.sort(winners.get(0));
        Collections.sort(winners.get(1));

        return winners;
    }
}
