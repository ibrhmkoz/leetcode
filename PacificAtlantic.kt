class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val dirs = arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        val pacific = mutableSetOf<Pair<Int, Int>>()
        val atlantic = mutableSetOf<Pair<Int, Int>>()

        fun dfs(i: Int, j: Int, visited: MutableSet<Pair<Int, Int>>) {
            if (!visited.add(i to j)) return
            dirs.forEach { (di, dj) ->
                val ni = i + di
                val nj = j + dj
                if (ni in heights.indices && nj in heights[0].indices &&
                    heights[ni][nj] >= heights[i][j]) {
                    dfs(ni, nj, visited)
                }
            }
        }

        heights.indices.forEach { i ->
            dfs(i, 0, pacific)
            dfs(i, heights[0].lastIndex, atlantic)
        }
        heights[0].indices.forEach { j ->
            dfs(0, j, pacific)
            dfs(heights.lastIndex, j, atlantic)
        }

        return pacific.intersect(atlantic).map { listOf(it.first, it.second) }
    }
}
