package countNumberOfNiceSubarrays;

public class CountNumberOfNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int countNumberOfNiceSubarray = 0;

        int currentOddNums = 0;

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 != 0) {
                currentOddNums++;

                if (currentOddNums == k) {
                    while (nums[l] % 2 == 0) {
                        l++;
                    }

                    if (l > r) {
                        continue;
                    }

                    int leftEvenSum = 1;
                    int rightEvenSum = 1;

                    for (int j = l - 1; j >= 0; j--) {
                        if (nums[j] % 2 == 0) {
                            leftEvenSum++;
                        } else {
                            break;
                        }
                    }

                    for (int j = r + 1; j < nums.length; j++) {
                        if (nums[j] % 2 == 0) {
                            rightEvenSum++;
                        } else {
                            break;
                        }
                    }

                    countNumberOfNiceSubarray += leftEvenSum * rightEvenSum;

                    l++;
                    currentOddNums--;
                }
            }
        }

        return countNumberOfNiceSubarray;
    }
}
