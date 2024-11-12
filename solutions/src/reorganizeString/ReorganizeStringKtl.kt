package reorganizeString

import java.util.*

class ReorganizeStringKtl {
    fun reorganizeString(s: String): String {
        val charCountMap = mutableMapOf<Char, Int>()

        s.forEach { char ->
            charCountMap[char] = charCountMap.getOrDefault(char, 0) + 1
        }

        val heap = PriorityQueue<Map.Entry<Char, Int>>(compareByDescending { it.value })
        heap.addAll(charCountMap.entries)

        val sb = StringBuilder()
        var prev: Map.Entry<Char, Int>? = null

        while (heap.isNotEmpty()) {
            val current = heap.poll()

            sb.append(current.key)
            current.setValue(current.value - 1)

            if (prev != null && prev.value > 0) {
                heap.add(prev)
            }

            prev = current
        }

        return if (sb.length == s.length) sb.toString() else ""
    }
}