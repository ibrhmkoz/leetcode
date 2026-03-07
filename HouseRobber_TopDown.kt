class Solution {
    fun rob(nums: IntArray): Int {
        val cache = mutableMapOf<Int, Int>()
        fun _rob(i: Int): Int {
            if (i >= nums.size) {
                return 0
            }

            return cache.getOrPut(i) {
                maxOf(nums[i] + _rob(i + 2), _rob(i + 1))
            }
        }

        return _rob(0)
    }
}
