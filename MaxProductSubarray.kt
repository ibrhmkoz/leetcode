class Solution {
    fun maxProduct(nums: IntArray): Int {
        var min = nums.first()
        var max = nums.first()
        var globMax = nums.first()
        
        for (num in nums.asSequence().drop(1)) {
            val oldMin = min
            val oldMax = max
            min = minOf(oldMin * num, oldMax * num, num)
            max = maxOf(oldMax * num, oldMin * num, num)

            globMax = maxOf(max, globMax)
        }

        return globMax
    }
}
