package lengthOfLongestSubarrayWithAtMostKFrequency

import kotlin.math.max

class LengthOfLongestSubarrayWithAtMostKFrequencyKtl {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val numCountMap = mutableMapOf<Int, Int>()
        var maxSize = 0
        var l = 0

        for (r in nums.indices) {
            numCountMap[nums[r]] = numCountMap.getOrDefault(nums[r], 0) + 1

            while (numCountMap[nums[r]]!! > k) {
                numCountMap[nums[l]] = numCountMap[nums[l]]!! - 1

                l++;
            }

            maxSize = max(maxSize, r - l + 1)
        }

        return maxSize;
    }
}