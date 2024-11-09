package minimumDeletionsToMakeCharacterFrequenciesUnique

class MinimumDeletionsToMakeCharacterFrequenciesUniqueKtl {
    fun minDeletions(s: String): Int {
        val charCountMap = s.groupingBy { it }.eachCount()
        var deletions = 0
        val freq = mutableSetOf<Int>()

        for (value in charCountMap.values) {
            var currentValue = value
            while (currentValue > 0 && !freq.add(currentValue)) {
                currentValue--
                deletions++
            }
        }

        return deletions
    }
}