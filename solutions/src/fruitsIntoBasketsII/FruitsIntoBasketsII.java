package fruitsIntoBasketsII;

public class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] banned = new boolean[baskets.length];
        int c = 0;
        first: for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (!banned[j] && fruit <= baskets[j]) {
                    banned[j] = true;
                    continue first;
                }
            }
            c++;
        }
        return c;
    }
}
