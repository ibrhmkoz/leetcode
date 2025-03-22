class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val cache = mutableMapOf<Int, Int>()
        fun bt(sum: Int): Int {
            if (sum == 0) return 0
            else if (sum < 0) return -1
            cache[sum]?.let { return it }

            val result = coins.asSequence()
                .map { bt(sum - it) }
                .filterNot { it == -1 }
                .minOfOrNull { it + 1 } ?: -1


            cache[sum] = result

            return result
        }

        return bt(amount)
    }
}