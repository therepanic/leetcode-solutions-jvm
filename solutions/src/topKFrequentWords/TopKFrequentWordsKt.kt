package topKFrequentWords

class TopKFrequentWordsKt {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        return words.groupingBy { it }.eachCount()
            .entries
            .sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }.thenBy { it.key })
            .take(k)
            .map { it.key }
    }
}