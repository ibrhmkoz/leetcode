class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val m = matrix.size
        val n = matrix[0].size
        val res = mutableListOf<Int>()
        val dirs = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        val visited = Array(m) { BooleanArray(n) }

        var d = 0
        var i = 0
        var j = 0
        repeat(m * n) {
            res.add(matrix[i][j])
            visited[i][j] = true
            var ni = i + dirs[d].first
            var nj = j + dirs[d].second
            if (ni !in 0..<m || nj !in 0..<n || visited[ni][nj]) {
                d = (d + 1) % 4
                ni = i + dirs[d].first
                nj = j + dirs[d].second
            }
            i = ni
            j = nj
        }
        return res
    }
}
