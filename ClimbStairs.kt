class Solution {
    fun climbStairs(n: Int): Int {
        val cache = mutableMapOf<Int, Int>()
        fun climb(sum: Int): Int {
            if (sum == n) return 1
            else if (sum > n) return 0

            cache[sum]?.let { return it }

            val count = (1..2).sumOf { climb(sum + it) }
            cache[sum] = count
            return count
        }

        return climb(0)
    }
}