package minimumSwapsToGroupAll1sTogetherII

class MinimumSwapsToGroupAll1sTogetherIIKtl {
    fun minSwaps(nums: IntArray): Int {
        var allOneCount = 0

        for (num in nums) {
            if (num == 1) allOneCount++
        }

        var l = 0
        var r = 0
        var zeroCount = 0
        var minZeroCount = Int.MAX_VALUE

        while (r < nums.size + allOneCount - 1) {
            if (r < allOneCount) {
                if (nums[r] == 0) zeroCount++
                r++
                continue
            }

            minZeroCount = minOf(minZeroCount, zeroCount)

            if (nums[l % nums.size] == 0) {
                zeroCount--
            }

            l++

            if (nums[r % nums.size] == 0) {
                zeroCount++
            }
            r++
        }

        minZeroCount = minOf(minZeroCount, zeroCount)

        return minZeroCount
    }

}