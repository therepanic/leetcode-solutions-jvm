package minimumAverageDifference

class MinimumAverageDifferenceKt {
    fun minimumAverageDifference(nums: IntArray): Int {
        val left = LongArray(nums.size)
        val right = LongArray(nums.size)

        var sum: Long = 0

        for (i in nums.indices) {
            sum += nums[i]
            left[i] = sum / (i + 1)
        }

        sum = 0

        for (i in nums.size - 1 downTo 0) {
            sum += nums[i]
            right[i] = sum.toDouble().toLong() / (nums.size - i)
        }

        var min = Int.MAX_VALUE
        var `val` = Long.MAX_VALUE

        for (i in nums.indices) {
            var sumd = left[i]

            if (i != nums.size - 1) {
                sumd = Math.abs(sumd - right[i + 1])
            }

            if (sumd < `val`) {
                `val` = sumd
                min = i
            }
        }

        return min
    }

}