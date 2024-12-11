package reorderRoutesToMakeAllPathsLeadToTheCityZero

class ReorderRoutesToMakeAllPathsLeadToTheCityZeroKt {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val graph = List(n) { mutableListOf<Int>() }
        val graphReversed = List(n) { mutableListOf<Int>() }

        for (connection in connections) {
            graph[connection[0]].add(connection[1])
            graphReversed[connection[1]].add(connection[0])
        }

        var count = 0

        fun helper(node: Int, visited: MutableSet<Int>): Boolean {
            if (node in visited) return false
            visited.add(node)

            for (curNode in graph[node]) {
                if (helper(curNode, visited)) {
                    count++
                }
            }

            for (curNode in graphReversed[node]) {
                helper(curNode, visited)
            }

            visited.remove(node)

            return true
        }

        helper(0, mutableSetOf())

        return count
    }
}