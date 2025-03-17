class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableList<Int>>()

        for (p in prerequisites) {
            graph.getOrPut(p[1]) { mutableListOf() }.add(p[0])
        }

        val cache = mutableMapOf<Int, Boolean>()
        val visited = mutableSetOf<Int>()
        fun hasCycle(node: Int): Boolean {
            cache[node]?.let { return it }

            if (visited.contains(node)) return true

            visited.add(node)

            val adjacentNodes = graph[node]
            val has = adjacentNodes?.any { hasCycle(it) } == true

            visited.remove(node)
            cache[node] = has
            return has
        }

        return !graph.keys.any { hasCycle(it) }
    }
}