package invalidTransactions;

import java.util.*;

public class InvalidTransactions {

    public static List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        String[][] transactionSplit = new String[n][5];
        for (int i = 0; i < n; i++) {
            String[] split = transactions[i].split("\\,");
            transactionSplit[i] = new String[] {String.valueOf(i), split[0], split[1], split[2], split[3]};
        }
        Arrays.sort(transactionSplit, Comparator.comparingInt(p -> Integer.parseInt(p[2])));
        Set<Integer> already = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(transactionSplit[i][3]) > 1000) {
                already.add(Integer.parseInt(transactionSplit[i][0]));
            }
            int curTime = Integer.parseInt(transactionSplit[i][2]);
            for (int j = i + 1; j < n; j++) {
                int time = Integer.parseInt(transactionSplit[j][2]);
                if (time - curTime <= 60 && (transactionSplit[i][1].equals(transactionSplit[j][1]) && !transactionSplit[i][4].equals(transactionSplit[j][4]))) {
                    already.add(Integer.parseInt(transactionSplit[i][0]));
                    already.add(Integer.parseInt(transactionSplit[j][0]));
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int idx : already) {
            result.add(transactions[idx]);
        }
        return result;
    }

}
