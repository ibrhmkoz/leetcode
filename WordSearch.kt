class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val dirs = listOf(
            0 to 1,
            0 to -1,
            1 to 0,
            -1 to 0
        )
        val visited = Array(board.size) { BooleanArray(board.first().size) }

        fun search(x: Int, y: Int, i: Int): Boolean {
            if (i == word.length) {
                return true
            }
            if ((x !in board.indices || y !in board.first().indices) || (visited[x][y])) {
                return false
            }
            if (word[i] != board[x][y]) {
                return false
            }

            visited[x][y] = true
            return dirs.any { search(x + it.first, y + it.second, i + 1) }.also { visited[x][y] = false }
        }

        return board.indices.any { x ->
            board.first().indices.any { y ->
                search(x, y, 0)
            }
        }
    }
}
