class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((from, to) in prerequisites) {
            graph.getOrPut(from) { mutableListOf() }.add(to)
        }

        val cache = mutableMapOf<Int, Boolean>()
        val path = mutableSetOf<Int>()
        fun hasCycle(node: Int): Boolean =
            cache.getOrPut(node) {
                if (!path.add(node)) {
                    true
                } else {
                    graph
                        .getOrElse(node) { mutableSetOf() }
                        .any { hasCycle(it) }
                        .also { path.remove(node) }
                }
            }

        return !graph.keys.any { hasCycle(it) }
    }
}
