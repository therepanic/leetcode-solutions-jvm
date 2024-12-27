package productOfTheLastKNumbers

class ProductOfNumbersKt {
    private var oneCount = 0
    private var zeroIndex = -1
    private val nums = mutableListOf<Int>()

    fun add(num: Int) {
        nums.add(num)
        when (num) {
            1 -> oneCount++
            0 -> zeroIndex = nums.size - 1
        }
    }

    fun getProduct(k: Int): Int {
        if (oneCount == nums.size) return 1
        if (zeroIndex >= nums.size - k) return 0
        var product = nums.last()

        for (i in nums.size - 2 downTo nums.size - k) {
            product *= nums[i]
        }
        return product
    }
}