class Solution {
    fun rob(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()
        fun maxRob(i: Int): Int {
            if (i !in nums.indices) return 0
            cache[i]?.let { return it }
            val result = maxOf(nums[i] + maxRob(i + 2), maxRob(i + 1))
            cache[i] = result
            return result
        }

        return maxRob(0)
    }
}