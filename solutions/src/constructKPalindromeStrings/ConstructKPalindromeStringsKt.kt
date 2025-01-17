package constructKPalindromeStrings

class ConstructKPalindromeStringsKt {
    fun canConstruct(s: String, k: Int): Boolean {
        if (s.length < k) return false

        val charCount = IntArray(26)

        for (i in s.indices) {
            val c = s[i]
            charCount[c - 'a']++
        }

        var oddCount = 0
        for (count in charCount) {
            if (count % 2 != 0) {
                oddCount++
            }
        }

        return oddCount <= k
    }

}