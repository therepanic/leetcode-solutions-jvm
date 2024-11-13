package maxConsecutiveOnesIII

class MaxConsecutiveOnesIIIKtl {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var oneCount = 0
        var zeroCount = 0

        var l = 0
        var answer = 0

        for (r in nums.indices) {
            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--
                } else {
                    oneCount--
                }
                l++
            }

            answer = maxOf(answer, oneCount + zeroCount)

            when (nums[r]) {
                0 -> zeroCount++
                1 -> oneCount++
            }
        }

        if (zeroCount <= k) {
            answer = maxOf(answer, oneCount + zeroCount)
        }

        return answer
    }
}