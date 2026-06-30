class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val dirs = listOf(
            -1 to 0,
            1 to 0,
            0 to 1,
            0 to -1
        )

        fun dfs(i: Int, j: Int, n: Int): Boolean {
            if (n > word.lastIndex) {
                return true
            }
            if (i !in board.indices || j !in board.first().indices) {
                return false
            }
            if (board[i][j] != word[n]) {
                return false
            }

            val original = board[i][j]
            board[i][j] = '#'
            val found =
                dirs.any { (r, c) -> dfs(i + r, j + c, n + 1) }
            board[i][j] = original
            return found
        }

        for (i in board.indices) {
            for (j in board.first().indices) {
                if (dfs(i, j, 0)) {
                    return true
                }
            }
        }

        return false
    }
}
