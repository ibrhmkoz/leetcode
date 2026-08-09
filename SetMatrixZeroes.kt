class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val row0 = matrix[0].any { it == 0 }
        val col0 = matrix.indices.any { matrix[it][0] == 0 }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1..matrix.lastIndex) {
            for (j in 1..matrix[0].lastIndex) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (row0) {
            for (j in matrix[0].indices) {
                matrix[0][j] = 0
            }
        }
        if (col0) {
            for (i in matrix.indices) {
                matrix[i][0] = 0
            }
        }
    }
}
