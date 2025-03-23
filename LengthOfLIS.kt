class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int>().apply {
            set(nums.lastIndex, 1)
        }

        fun f(i: Int): Int {
            cache[i]?.let { return it }

            val result = ((i + 1)..nums.lastIndex).filter { nums[it] > nums[i] }.maxOfOrNull { 1 + f(it) } ?: 1
            cache[i] = result
            return result
        }

        for (i in nums.indices) {
            f(i)
        }

        return cache.values.max()
    }
}