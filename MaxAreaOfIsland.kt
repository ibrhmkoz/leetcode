class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val dirs = listOf(
            0 to 1,
            1 to 0,
            0 to -1,
            -1 to 0
        )

        var area = 0
        val visited = mutableSetOf<Pair<Int, Int>>()
        fun expand(i: Int, j: Int) {
            if (!visited.add(i to j) || (i !in grid.indices || j !in grid.first().indices)) {
                return
            }
            if (grid[i][j] == 1) {
                area++
                for ((di, dj) in dirs) {
                    expand(i + di, j + dj)
                }
            }
        }

        var max = 0
        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (i to j !in visited && grid[i][j] == 1) {
                    expand(i, j)
                    max = maxOf(max, area)
                    area = 0
                }
            }
        }

        return max
    }
}
