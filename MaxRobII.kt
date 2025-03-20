class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        else if (nums.size == 1) return nums[0]

        val cache = mutableMapOf<Int, Int>()
        fun maxRob(arr: IntArray, i: Int): Int {
            if (i !in arr.indices) return 0
            cache[i]?.let { return it }
            val result = maxOf(arr[i] + maxRob(arr, i + 2), maxRob(arr, i + 1))
            cache[i] = result
            return result
        }

        val includingFirst = maxRob(nums.slice(0 until nums.lastIndex).toIntArray(), 0)
        cache.clear()
        val includingLast = maxRob(nums.slice(1..nums.lastIndex).toIntArray(), 0)
        return maxOf(
            includingFirst,
            includingLast,
        )
    }
}