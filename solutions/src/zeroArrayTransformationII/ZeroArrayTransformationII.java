package zeroArrayTransformationII;

public class ZeroArrayTransformationII {
    public int minZeroArray(int[] nums, int[][] queries) {
        boolean equal = true;
        for (int num : nums) {
            if (num != 0) {
                equal = false;
                break;
            }
        }
        if (equal) return 0;

        int l = 0;
        int r = queries.length - 1;

        int k = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int[] pref = new int[nums.length];

            for (int i = 0; i <= mid; i++) {
                int[] query = queries[i];

                pref[query[0]] += query[2];

                if (query[1] + 1 < pref.length) {
                    pref[query[1] + 1] -= query[2];
                }
            }

            for (int i = 1; i < pref.length; i++) {
                pref[i] += pref[i - 1];
            }

            boolean ok = true;

            for (int i = 0; i < pref.length; i++) {
                if (pref[i] < nums[i]) {
                    ok = false;
                    break;
                }
            }

            //System.out.println(mid + " ");

            if (ok) {
                //System.out.println(mid);
                r = mid - 1;
                k = mid;
            } else {
                l = mid + 1;
            }
        }


        return k == -1 ? -1 : k + 1;
    }
}
