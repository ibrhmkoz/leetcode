/*
 * General recipe for deriving these matrix-rotation tricks yourself:
 *
 * 1. Write down the coordinate mapping you actually want: (row, col) -> (?, ?).
 * 2. See if it factors into two mappings you already know are easy to code
 *    (transpose, row-reverse, column-reverse, flip along anti-diagonal).
 * 3. Check by composing them algebraically - do they multiply out to the
 *    target formula?
 *
 * Example: clockwise 90 rotation -> (row, col) -> (col, n-1-row)
 *          = transpose, then reverse each row.
 *
 * Counter-clockwise 90 rotation instead? Derive the formula:
 *          (row, col) -> (n-1-col, row)
 *          = transpose, then reverse each column
 *          (equivalently: reverse each row first, then transpose).
 * Same method, different composition.
 */

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
