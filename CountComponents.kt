class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableList<Int>>()

        for ((u, v) in edges) {
            graph.getOrPut(u) { mutableListOf() }.add(v)
            graph.getOrPut(v) { mutableListOf() }.add(u)
        }

        val visited = BooleanArray(n) { false }

        fun dfs(u: Int) {
            if (visited[u]) {
                return
            }
            visited[u] = true

            graph[u]?.forEach { v ->
                dfs(v)
            }
        }

        var res = 0

        for (i in 0 until n) {
            if (!visited[i]) {
                res++
                dfs(i)
            }
        }

        return res
    }
}
