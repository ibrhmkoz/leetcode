class Solution {
    fun climbStairs(n: Int): Int {
        val cache = mutableMapOf(n to 1)

        fun climb(sum: Int): Int {
            if (sum > n) return 0
            return cache.getOrPut(sum) {
                (1..2).sumOf { climb(sum + it) }
            }
        }

        return climb(0)
    }
}
