class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val res = ArrayList<Int>(m * n)
        val dirs = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)  // right, down, left, up
        val steps = intArrayOf(n, m - 1)
        var i = 0
        var j = -1
        var d = 0
        while (steps[d % 2] > 0) {
            val (di, dj) = dirs[d]
            repeat(steps[d % 2]) {
                i += di
                j += dj
                res.add(matrix[i][j])
            }
            steps[d % 2]--
            d = (d + 1) % 4
        }
        return res
    }
}
