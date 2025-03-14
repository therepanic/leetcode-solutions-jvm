package maximumCandiesAllocatedToKChildren;

public class MaximumCandiesAllocatedToKChildren {
    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[] {1,2,3,4,10}, 5));
    }
    public static int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        int l = 1;
        int r = max;
        int answer = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long kids = 0;
            for (int i = 0; i < candies.length; i++) {
                kids += (long) candies[i] / mid;
                if (kids >= k) {
                    answer = Math.max(mid, answer);
                    break;
                }
            }
            if (kids >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}
