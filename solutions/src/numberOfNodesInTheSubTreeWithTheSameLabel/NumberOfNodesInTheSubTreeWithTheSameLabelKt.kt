package numberOfNodesInTheSubTreeWithTheSameLabel

class NumberOfNodesInTheSubTreeWithTheSameLabelKt {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val labelChars = labels.toCharArray()
        val graph = List(n) { mutableListOf<Int>() }
        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }
        val result = IntArray(n)
        dfs(0, graph, labelChars, result, BooleanArray(n))
        return result
    }

    private fun dfs(curNode: Int, graph: List<List<Int>>, labelChars: CharArray,
                    result: IntArray, checked: BooleanArray): IntArray? {
        if (checked[curNode]) return null
        checked[curNode] = true
        val answer = IntArray(26)
        answer[labelChars[curNode] - 'a']++
        for (node in graph[curNode]) {
            val poll = dfs(node, graph, labelChars, result, checked) ?: continue
            for (i in 0 until 26) {
                answer[i] += poll[i]
            }
        }
        result[curNode] = answer[labelChars[curNode] - 'a']
        return answer
    }
}