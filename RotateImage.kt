class Solution {
    fun rotate(matrix: Array<IntArray>) {
        for (i in matrix.indices) {
            for (j in i..matrix[0].lastIndex) {
                val t = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = t
            }
        }

        matrix.forEach { it.reverse() }
    }
}
