class Solution {
    fun rob(nums: IntArray): Int {
        var f = 0
        var s = 0
        for (num in nums) {
            val n = maxOf(f + num, s)
            f = s
            s = n
        }
        return s
    }
}
