package addMinimumNumberOfRungs;

public class AddMinimumNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
       int val = 0;
       int c = 0;
       for (int i = 0; i < rungs.length; i++) {
           if (rungs[i] - val > dist) {
               c += (int) Math.ceil((((double) rungs[i] - val) / dist) - 1);
           }
           val = rungs[i];
       }
       return c;
    }
}
