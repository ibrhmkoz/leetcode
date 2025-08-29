class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableSet<Int>>()
        for ((u, v) in edges) {
            graph.getOrPut(u) { mutableSetOf() }.add(v)
            graph.getOrPut(v) { mutableSetOf() }.add(u)
        }

        val path = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()
        fun hasCycle(node: Int, prev: Int): Boolean {
            visited.add(node)
            return if (!path.add(node)) {
                true
            } else {
                (graph.getOrElse(node) { emptySet() } - prev)
                    .any { hasCycle(it, node) }
                    .also { path.remove(node) }
            }
        }

        return !hasCycle(0, -1) && visited.size == n
    }
}
