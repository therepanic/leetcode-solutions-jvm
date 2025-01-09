package maximumPointsYouCanObtainFromCards

class MaximumPointsYouCanObtainFromCardsKt {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var sum = 0
        for (num in cardPoints) {
            sum += num
        }

        var minSum = Int.MAX_VALUE
        var curSum = 0
        var l = 0

        val windowSize = cardPoints.size - k

        for (r in cardPoints.indices) {
            curSum += cardPoints[r]
            if (r - l + 1 > windowSize) {
                curSum -= cardPoints[l]
                l++
            }

            if (r - l + 1 == windowSize) {
                minSum = minOf(minSum, curSum)
            }
        }

        return sum - minSum
    }

}