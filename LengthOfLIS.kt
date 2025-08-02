class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = mutableMapOf(
            nums.lastIndex to 1
        )

        fun lisFromIndex(i: Int): Int = cache.getOrPut(i) {
            (i + 1..nums.lastIndex).filter { nums[it] > nums[i] }.maxOfOrNull { 1 + lisFromIndex(it) } ?: 1
        }

        for (i in nums.indices) {
            lisFromIndex(i)
        }

        return cache.values.max()
    }
}
