package reorderedPowerOf2

class ReorderedPowerOf2Ktl {
    fun reorderedPowerOf2(n: Int): Boolean {
        val nums = n.toString().toCharArray().sorted()

        return generateSequence(1) {it * 2}.takeWhile { it <= 1_000_000_000 }
            .any {it.toString().toCharArray().sorted() == nums}
    }
}