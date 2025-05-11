class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var localMax = 0
        for (num in nums) {
            if (localMax < 0) {
                localMax = num
            } else {
                localMax += num
            }

            max = maxOf(max, localMax)
        }
        return max
    }
}
