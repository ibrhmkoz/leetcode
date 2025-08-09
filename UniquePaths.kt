class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()
        fun up(i: Int, j: Int): Int =
            if (i == 0 || j == 0) 1
            else cache.getOrPut(i to j) {
                up(i - 1, j) + up(i, j - 1)
            }
        
        return up(m - 1, n - 1)
    }
}
