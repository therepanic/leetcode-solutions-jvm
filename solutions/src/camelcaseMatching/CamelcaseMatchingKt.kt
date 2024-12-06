package camelcaseMatching

class CamelcaseMatchingKt {
    fun camelMatch(queries: Array<String>, pattern: String): List<Boolean> {
        val matching = mutableListOf<Boolean>()
        val patternChars = pattern.toCharArray()

        for (query in queries) {
            val queryChars = query.toCharArray()
            var j = 0
            var isOk = true

            for (c in queryChars) {
                if (j < patternChars.size && c == patternChars[j]) {
                    j++
                } else if (c.isUpperCase()) {
                    isOk = false
                    break
                }
            }

            if (j < patternChars.size) {
                isOk = false
            }

            matching.add(isOk)
        }

        return matching
    }
}