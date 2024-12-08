package minimumFuelCostToReportToTheCapital

class MinimumFuelCostToReportToTheCapitalKtl {
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val graph = MutableList(roads.size + 1) { mutableListOf<Int>() }

        for (road in roads) {
            graph[road[0]].add(road[1])
            graph[road[1]].add(road[0])
        }

        val answer = longArrayOf(0)

        dfs(0, seats, graph, BooleanArray(roads.size + 1), answer)

        return answer[0]
    }

    private fun dfs(node: Int, seats: Int, graph: List<MutableList<Int>>, visited: BooleanArray, answer: LongArray): Long {
        if (visited[node]) return 0
        visited[node] = true

        var count: Long = 1
        for (curNode in graph[node]) {
            count += dfs(curNode, seats, graph, visited, answer)
        }

        if (node != 0) {
            answer[0] += (count + seats - 1) / seats
        }

        return count
    }

}