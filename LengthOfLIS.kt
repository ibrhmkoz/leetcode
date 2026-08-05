class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = mutableMapOf(nums.lastIndex to 1)
        fun lis(i: Int): Int =
            cache.getOrPut(i) {
                (i + 1..nums.lastIndex)
                    .filter { nums[it] > nums[i] }
                    .maxOfOrNull { 1 + lis(it) } ?: 1
            }
        
        return nums.indices.maxOfOrNull { lis(it) } ?: 0
    }
}
