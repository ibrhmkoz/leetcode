class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()

        // Populate the queue with initial rotten cells
        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == 2) {
                    queue.add(i to j)
                    visited.add(i to j)
                }
            }
        }

        val dirs = listOf(
            0 to 1,
            0 to -1,
            -1 to 0,
            1 to 0,
        )

        var count = -1
        while (queue.isNotEmpty()) {
            count++
            val currentLevel = queue.size
            repeat(currentLevel) {
                val (i, j) = queue.removeFirst()
                grid[i][j] = 2
                for ((di, dj) in dirs) {
                    val ni = i + di
                    val nj = j + dj
                    if (ni in grid.indices && nj in grid.first().indices
                        && visited.add(ni to nj)
                        && grid[ni][nj] == 1
                    ) {
                        queue.add(ni to nj)
                    }
                }
            }
        }

        for (i in grid.indices) {
            for (j in grid.first().indices) {
                if (grid[i][j] == 1) {
                    return -1
                }
            }
        }

        return if (count == -1) 0 else count
    }
}
