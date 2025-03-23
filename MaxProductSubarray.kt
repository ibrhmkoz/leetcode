class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums.max()
        var localMin = 1
        var localMax = 1

        for (n in nums) {
            if (n == 0) {
                localMin = 1
                localMax = 1
                continue
            }
            var tmp = localMax
            localMax = maxOf(localMax * n, n, localMin * n)
            localMin = minOf(tmp * n, n, localMin * n)
            max = maxOf(localMax, max)
        }
        return max
    }
}