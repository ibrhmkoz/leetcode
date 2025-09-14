class Solution {
    fun solve(board: Array<CharArray>): Unit {
        val dirs = listOf(
            0 to 1,
            0 to -1,
            -1 to 0,
            1 to 0
        )

        fun dfs(i: Int, j: Int) {
            if (i !in board.indices || j !in board.first().indices || board[i][j] != 'O') {
                return
            }
            board[i][j] = 'E'
            for ((di, dj) in dirs) {
                dfs(i + di, j + dj)
            }
        }

        for (j in board.first().indices) {
            if (board[0][j] == 'O') {
                dfs(0, j)
            }
            val lastRow = board.lastIndex
            if (board[lastRow][j] == 'O') {
                dfs(lastRow, j)
            }
        }

        for (i in board.indices) {
            if (board[i][0] == 'O') {
                dfs(i, 0)
            }
            val lastCol = board.first().lastIndex
            if (board[i][lastCol] == 'O') {
                dfs(i, lastCol)
            }
        }

        for (i in board.indices) {
            for (j in board.first().indices) {
                when (board[i][j]) {
                    'E' -> board[i][j] = 'O'
                    'O' -> board[i][j] = 'X'
                }
            }
        }
    }
}
