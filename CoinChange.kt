class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val cache = mutableMapOf<Int, Int>()

        fun pick(sum: Int): Int = when {
            sum == 0 -> 0
            sum < 0 -> -1
            else -> cache.getOrPut(sum) {
                coins.asSequence()
                    .map { pick(sum - it) }
                    .filterNot { it == -1 }
                    .minOfOrNull { it + 1 } ?: -1
            }
        }

        return pick(amount)
    }
}
