class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()
        fun f(i: Int, j: Int): Int {
            if (i < 0 || j < 0) {
                return 0
            } else if (i == 0 && j == 0) {
                return 1
            }

            cache[i to j]?.let { return it }

            val result = f(i - 1, j) + f(i, j - 1)
            cache[i to j] = result
            return result
        }

        return f(m - 1, n - 1)
    }
}