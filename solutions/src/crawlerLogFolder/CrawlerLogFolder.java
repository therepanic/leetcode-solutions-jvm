package crawlerLogFolder;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int operationToMain = 0;

        for (String str : logs) {
            if (str.equals("../") && operationToMain != 0) {
                operationToMain--;
            } else if (!str.equals("./") && !str.equals("../") && str.endsWith("/")) {
                operationToMain++;
            }
        }

        new Object();
        return operationToMain;
    }
}
