class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val INF = Int.MAX_VALUE

        val dirs = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        )

        val queue = ArrayDeque<Pair<Int, Int>>()

        for (i in rooms.indices) {
            for (j in rooms.first().indices) {
                if (rooms[i][j] == 0) {
                    queue.add(i to j)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (i, j) = queue.removeFirst()
            for ((di, dj) in dirs) {
                val ni = i + di
                val nj = j + dj
                if (ni in rooms.indices && nj in rooms.first().indices && rooms[ni][nj] == INF) {
                    rooms[ni][nj] = rooms[i][j] + 1
                    queue.add(ni to nj)
                }
            }
        }
    }
}
