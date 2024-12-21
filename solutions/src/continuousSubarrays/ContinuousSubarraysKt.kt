package continuousSubarrays

class ContinuousSubarraysKt {
    fun continuousSubarrays(nums: IntArray): Long {
        val minDeque = ArrayDeque<Int>()
        val maxDeque = ArrayDeque<Int>()

        var count = 0L
        var l = 0

        for (r in nums.indices) {
            while (minDeque.isNotEmpty() && nums[minDeque.last()] >= nums[r]) {
                minDeque.removeLast()
            }
            minDeque.addLast(r)

            while (maxDeque.isNotEmpty() && nums[maxDeque.last()] <= nums[r]) {
                maxDeque.removeLast()
            }
            maxDeque.addLast(r)

            while (nums[maxDeque.first()] - nums[minDeque.first()] > 2) {
                if (minDeque.first() == l) {
                    minDeque.removeFirst()
                }

                if (maxDeque.first() == l) {
                    maxDeque.removeFirst()
                }

                l++
            }

            count += (r - l + 1).toLong()
        }

        return count
    }

}