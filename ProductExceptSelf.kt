class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }

        var pre = 1
        for (r in 0 until nums.lastIndex) {
            pre *= nums[r]
            res[r + 1] = pre
        }

        var post = 1
        for (l in nums.lastIndex downTo 1) {
            post *= nums[l]
            res[l - 1] *= post
        }

        return res
    }
}
