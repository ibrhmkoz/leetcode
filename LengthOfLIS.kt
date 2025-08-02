class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = mutableMapOf(
            nums.lastIndex to 1
        )

        fun f(i: Int): Int {
            return cache.getOrPut(i) {
                (i + 1..nums.lastIndex).filter { nums[it] > nums[i] }.maxOfOrNull { 1 + f(it) } ?: 1
            }
        }

        for (i in nums.indices) {
            f(i)
        }

        return cache.values.max()
    }
}
