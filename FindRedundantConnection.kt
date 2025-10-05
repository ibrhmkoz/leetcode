class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val graph = mutableMapOf<Int, MutableList<Int>>()

        fun hasPath(source: Int, destination: Int, visited: MutableSet<Int>): Boolean {
            if (source !in visited) {
                if (source == destination) return true
                visited.add(source)

                for (neighbor in graph.getOrDefault(source, emptyList())) {
                    if (hasPath(neighbor, destination, visited)) {
                        return true
                    }
                }
            }
            return false
        }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            // Initialize nodes if they don't exist
            graph.getOrPut(u) { mutableListOf() }
            graph.getOrPut(v) { mutableListOf() }

            // Check for a path with a fresh 'visited' set
            if (hasPath(u, v, mutableSetOf())) {
                return edge
            }

            // If no path, add the edge
            graph[u]?.add(v)
            graph[v]?.add(u)
        }

        throw IllegalStateException("The input graph is guaranteed to have a redundant connection.")
    }
}
