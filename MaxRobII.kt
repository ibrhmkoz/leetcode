class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums.first()
        }
        val cache = mutableMapOf<Int, Int>()
        fun maxRob(houses: List<Int>, i: Int): Int {
            if (i > houses.lastIndex) return 0
            return cache.getOrPut(i) { maxOf(houses[i] + maxRob(houses, i + 2), maxRob(houses, i + 1)) }
        }
       
        return maxOf(
            maxRob(nums.asList().subList(0, nums.lastIndex), 0).also { cache.clear() },
            maxRob(nums.asList().subList(1, nums.size), 0)
        )
    }
}
