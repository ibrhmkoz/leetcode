class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val g = mutableMapOf<Int, MutableSet<Int>>()
        for ((u, v) in edges) {
            g.getOrPut(u) { mutableSetOf() }.add(v)
            g.getOrPut(v) { mutableSetOf() }.add(u)
        }

        val visited = mutableSetOf<Int>()
        fun hasCycle(p: Int, n: Int): Boolean =
            !visited.add(n) || ((g[n] ?: emptySet()) - p).any { hasCycle(n, it) }

        return !hasCycle(0, 0) && visited.size == n
    }
}
