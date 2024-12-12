package successfulPairsOfSpellsAndPotions

class SuccessfulPairsOfSpellsAndPotionsKt {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val nums = IntArray(spells.size)
        potions.sort()

        spells.forEachIndexed { index, spell ->
            var l = 0
            var r = potions.size - 1

            var count = 0
            while (l <= r) {
                val mid = (r + l) / 2

                if (spell.toLong() * potions[mid] >= success) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }

                count = mid
            }

            nums[index] = when {
                spell.toLong() * potions[count] >= success -> potions.size - count
                count + 1 < potions.size && spell.toLong() * potions[count + 1] >= success -> potions.size - count - 1
                else -> 0
            }
        }

        return nums
    }
}