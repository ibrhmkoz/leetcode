class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val m = nums.groupBy { it }
        return m.any { it.value.size > 1 }
    }
}
