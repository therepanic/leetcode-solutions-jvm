package numberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold

class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThresholdKtl {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var sum = 0
        var count = 0

        for (r in arr.indices) {
            sum += arr[r]

            if (r >= k) sum -= arr[r - k]

            if (r >= k - 1 && sum / k >= threshold) count++
        }
        return count
    }
}