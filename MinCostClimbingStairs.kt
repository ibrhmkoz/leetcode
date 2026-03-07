class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()
        fun dp(i: Int): Int {
            if (i >= cost.size) {
                return 0
            }

            return cache.getOrPut(i) {
                cost[i] + minOf(dp(i + 1), dp(i + 2))
            }
        }

        return minOf(dp(0), dp(1))
    }
}
