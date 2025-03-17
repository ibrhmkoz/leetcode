class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableSet<Int>>()

        for (edge in edges) {
            graph.getOrPut(edge[0], ::mutableSetOf).add(edge[1])
            graph.getOrPut(edge[1], ::mutableSetOf).add(edge[0])
        }

        val visited = mutableSetOf<Int>()

        fun hasCycle(node: Int, prev: Int): Boolean {
            if (visited.contains(node)) return true

            visited.add(node)
            val adj = graph[node]
            val has = if (adj != null) {
                (adj - prev).any { hasCycle(it, node) }
            } else {
                false
            }

            return has
        }

        if (hasCycle(0, 0)) {
            return false
        }

        return visited.size == n
    }
}