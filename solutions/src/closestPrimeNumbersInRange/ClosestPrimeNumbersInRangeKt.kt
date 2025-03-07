package closestPrimeNumbersInRange

class ClosestPrimeNumbersInRangeKt {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val isPrime = BooleanArray(right + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..right) {
            if (i * i > right) break
            if (isPrime[i]) {
                for (j in i * i..right step i) {
                    isPrime[j] = false
                }
            }
        }

        var pair = intArrayOf(-1, -1)
        var minDiff = Int.MAX_VALUE
        var lastOk: Int? = null

        for (i in left..right) {
            if (!isPrime[i]) continue
            lastOk?.let {
                val diff = i - it
                if (diff < minDiff) {
                    minDiff = diff
                    pair = intArrayOf(it, i)
                }
            }
            lastOk = i
        }

        return pair
    }

}