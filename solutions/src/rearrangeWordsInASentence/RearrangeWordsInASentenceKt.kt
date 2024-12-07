package rearrangeWordsInASentence

import java.util.*

class RearrangeWordsInASentenceKt {
    fun arrangeWords(text: String): String {
        val heap = PriorityQueue<Map.Entry<Int, String>> { a, b ->
            when {
                a.value.length > b.value.length -> 1
                a.value.length < b.value.length -> -1
                else -> a.key.compareTo(b.key)
            }
        }

        val strings = text.split(" ")

        strings.forEachIndexed { index, str ->
            heap.add(java.util.AbstractMap.SimpleEntry(index, str))
        }

        val sb = StringBuilder()

        while (heap.isNotEmpty()) {
            sb.append(heap.poll().value).append(" ")
        }

        sb.deleteCharAt(sb.length - 1)

        for (i in sb.indices) {
            if (sb[i].isUpperCase()) {
                sb.setCharAt(i, sb[i].lowercaseChar())
                break
            }
        }

        sb.setCharAt(0, sb[0].uppercaseChar())

        return sb.toString()
    }

}