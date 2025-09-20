class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((course, pre) in prerequisites) {
            graph.getOrPut(course) { mutableListOf() }.add(pre)
        }

        val order = mutableListOf<Int>()
        val visited = IntArray(numCourses)

        // 0: unvisited, 1: visiting, 2: no-cycle
        fun dfs(course: Int): Boolean {
            when (visited[course]) {
                1 -> return true
                2 -> return false
            }

            visited[course] = 1
            if ((graph[course] ?: emptySet()).any { dfs(it) }) {
                return true
            }
            visited[course] = 2
            order.add(course)
            return false
        }

        for (course in 0..<numCourses) {
            if (dfs(course)) {
                return intArrayOf()
            }
        }

        return order.toIntArray()
    }
}
