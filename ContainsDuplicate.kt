class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val m = mutableSetOf<Int>()

        for (n in nums) {
            if (!m.add(n)) return true
        }

        return false
    }
}