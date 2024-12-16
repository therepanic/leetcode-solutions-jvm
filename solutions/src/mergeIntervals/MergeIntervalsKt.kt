package mergeIntervals

class MergeIntervalsKt {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        val intervalsList = intervals.toMutableList()
        var i = 1
        while (i < intervalsList.size) {
            val first = intervalsList[i]
            val second = intervalsList[i - 1]

            if (first[0] <= second[1]) {
                second[1] = maxOf(second[1], first[1])
                intervalsList.removeAt(i)
            } else {
                i++
            }
        }

        return intervalsList.toTypedArray()
    }

}