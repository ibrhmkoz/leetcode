class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums.first()
        var localMax = 0
        for (n in nums) {
            localMax = maxOf(n, n + localMax)
            max = maxOf(max, localMax)
        }

        return max
    }
}
