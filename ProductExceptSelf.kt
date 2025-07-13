class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size).apply {
            this[0] = 1
        }

        for (i in 1..nums.lastIndex) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        // rp[nums.lastIndex] = 1
        // rp[nums.lastIndex - 1] = nums[lastIndex] * rp[nums.lastIndex] = nums[lastIndex]
        // rp[nums.lastIndex - 2] = rp[nums.lastIndex - 1] * nums[lastIndex - 1]
        // tp = rp * lp (tp stands for total product)
        var rp = nums.last()
        for (i in nums.lastIndex - 1 downTo 0) {
            result[i] *= rp
            rp = rp * nums[i]
        }

        return result
    }
}
