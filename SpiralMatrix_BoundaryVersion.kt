    class Solution {
        fun spiralOrder(matrix: Array<IntArray>): List<Int> {
            val res = mutableListOf<Int>()
            var top = 0;
            var bottom = matrix.lastIndex
            var left = 0;
            var right = matrix[0].lastIndex

            while (top <= bottom && left <= right) {
                for (j in left..right) res.add(matrix[top][j])
                top++
                for (i in top..bottom) res.add(matrix[i][right])
                right--
                if (top <= bottom) {
                    for (j in right downTo left) res.add(matrix[bottom][j])
                    bottom--
                }
                if (left <= right) {
                    for (i in bottom downTo top) res.add(matrix[i][left])
                    left++
                }
            }
            return res
        }
    }
