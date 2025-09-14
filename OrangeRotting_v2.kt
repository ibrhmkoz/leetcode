class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()

        // Populate the queue with initial rotten cells and count fresh ones.
        var freshCount = 0
        for (i in grid.indices) {
            for (j in grid.first().indices) {
                when (grid[i][j]) {
                    1 -> freshCount++
                    2 -> {
                        queue.add(i to j)
                        visited.add(i to j)
                    }
                }
            }
        }

        val dirs = listOf(
            0 to 1,
            0 to -1,
            -1 to 0,
            1 to 0,
        )

        var minutes = 0
        while (queue.isNotEmpty()) {
            if (freshCount > 0) {
                minutes++
            }
            val levelSize = queue.size
            repeat(levelSize) {
                val (i, j) = queue.removeFirst()
                for ((di, dj) in dirs) {
                    val ni = i + di
                    val nj = j + dj
                    if (ni in grid.indices && nj in grid.first().indices
                        && visited.add(ni to nj)
                        && grid[ni][nj] == 1
                    ) {
                        grid[ni][nj] = 2
                        freshCount--
                        queue.add(ni to nj)
                    }
                }
            }
        }

        return if (freshCount == 0) minutes else -1
    }
}
