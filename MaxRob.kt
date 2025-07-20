class Solution {
    fun rob(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()
        fun maxRob(i: Int): Int {
            if (i > nums.lastIndex) return 0
            return cache.getOrPut(i) { maxOf(nums[i] + maxRob(i + 2), maxRob(i + 1)) }
        }

        return maxRob(0)
    }
}
