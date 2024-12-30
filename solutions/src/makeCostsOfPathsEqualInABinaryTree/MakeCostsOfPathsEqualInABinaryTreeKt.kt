package makeCostsOfPathsEqualInABinaryTree

class MakeCostsOfPathsEqualInABinaryTreeKt {
    fun minIncrements(n: Int, cost: IntArray): Int {
        val sum = intArrayOf(0)
        helper(0, cost, sum)
        return sum[0]
    }

    fun helper(i: Int, cost: IntArray, sum: IntArray): Int {
        if (i >= cost.size) return 0

        val first = helper(i * 2 + 1, cost, sum)
        val second = helper(i * 2 + 2, cost, sum)

        sum[0] += Math.abs(first - second)

        return cost[i] + maxOf(first, second)
    }

}