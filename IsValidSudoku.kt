class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = mutableSetOf<String>()

        for (i in board.indices) {
            for (j in board.first().indices) {
                val c = board[i][j]
                if (c == '.') {
                    continue
                }
                if (!seen.add("$c@r$i") ||
                    !seen.add("$c@c$j") ||
                    !seen.add("$c@b${i / 3},${j / 3}")
                ) {
                    return false
                }
            }
        }

        return true
    }
}
