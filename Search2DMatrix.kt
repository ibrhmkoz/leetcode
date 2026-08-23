class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val M = matrix.size
        val N = matrix.first().size

        var lo = 0
        var hi = M * N - 1

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (matrix[mid / N][mid % N] >= target) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return matrix[lo / N][lo % N] == target
    }
}
