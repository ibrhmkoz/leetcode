class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val dirs = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        )

        fun bfs(i: Int, j: Int) {
            val queue = ArrayDeque<Pair<Int, Int>>().apply {
                add(i to j)
            }
            val visited = mutableSetOf(i to j)
            var depth = 0
            while (queue.isNotEmpty()) {
                val levelSize = queue.size
                repeat(levelSize) {
                    val (ci, cj) = queue.removeFirst()
                    rooms[ci][cj] = depth
                    for ((di, dj) in dirs) {
                        val ni = ci + di
                        val nj = cj + dj
                        if (ni in rooms.indices
                            && nj in rooms.first().indices
                            && rooms[ni][nj] > depth
                            && visited.add(ni to nj)
                        ) {
                            queue.add(ni to nj)
                        }
                    }
                }
                depth++
            }
        }

        for (i in rooms.indices) {
            for (j in rooms.first().indices) {
                if (rooms[i][j] == 0) {
                    bfs(i, j)
                }
            }
        }
    }
}
