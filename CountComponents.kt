class Solution {
    /**
     * @param n: the number of vertices
     * @param edges: the edges of undirected graph
     * @return: the number of connected components
     */
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableSet<Int>>()

        for (edge in edges) {
            graph.getOrPut(edge[0], ::mutableSetOf).add(edge[1])
            graph.getOrPut(edge[1], ::mutableSetOf).add(edge[0])
        }

        val visited = mutableSetOf<Int>()
        fun visit(node: Int, prev: Int) {
            if (visited.contains(node)) return
            visited.add(node)

            graph[node]?.let { adj ->
                (adj - prev).forEach {
                    visit(it, node)
                }
            }
        }

        var count = 0
        (0 until n).forEach {
            if (!visited.contains(it)) {
                count++
                visit(it, it)
            }
        }

        return count
    }
}