package twoSum2

class TwoSum2Ktl {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        numbers.sort()

        var l = 0
        var r = numbers.size - 1

        while (l < r) {
            val sum = numbers[l] + numbers[r]

            if (sum == target) {
                return intArrayOf(++l, ++r)
            } else if (sum < target) {
                l++
            } else {
                r--
            }
        }

        return intArrayOf()
    }
}