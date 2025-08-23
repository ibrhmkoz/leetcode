class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val dirs = listOf(
            0 to 1,
            0 to -1,
            -1 to 0,
            1 to 0
        )
        val visited = Array(grid.size) { BooleanArray(grid.first().size) }

        fun dfs(i: Int, j: Int) {
            if (i !in grid.indices || j !in grid.first().indices) {
                return
            }
            if (grid[i][j] == '0') {
                return
            }
            if (!visited[i][j]) {
                visited[i][j] = true
                dirs.forEach { dfs(i + it.first, j + it.second) }
            }
        }

        var count = 0

        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == '0') {
                    continue
                }
                if (!visited[i][j]) {
                    count++
                }
                dfs(i, j)
            }
        }

        return count
    }
}
