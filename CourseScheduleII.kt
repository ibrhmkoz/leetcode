class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        for ((course, pre) in prerequisites) {
            graph.getOrPut(course) { mutableListOf() }.add(pre)
        }

        val order = mutableListOf<Int>()
        val visited = IntArray(numCourses)

        // 0: unseen, 1 seen, 2 loop, 3 not-loop
        fun dfs(course: Int): Boolean {
            if (visited[course] == 1) {
                visited[course] = 2
                return true
            } else if (visited[course] == 2) {
                return true
            } else if (visited[course] == 3) {
                return false
            }

            visited[course] = 1
            if ((graph[course] ?: emptySet()).any { dfs(it) }) {
                visited[course] = 2
                return true
            }
            visited[course] = 3
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
