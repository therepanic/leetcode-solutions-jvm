package maximumMatchingOfPlayersWithTrainers;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;

        int playerIndex = 0;
        int pointer = 0;

        while (pointer < trainers.length && playerIndex < players.length) {
            while (pointer < trainers.length && trainers[pointer] < players[playerIndex]) {
                pointer++;
            }

            if (pointer < trainers.length && trainers[pointer] >= players[playerIndex]) {
                count++;
                pointer++;
            }


            playerIndex++;
        }


        return count;
    }
}
