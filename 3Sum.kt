class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (a in 0..nums.lastIndex - 2) {
            if (nums[a] > 0) {
                break // Optimization: No more triplets possible
            }
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue
            }

            var b = a + 1
            var c = nums.lastIndex

            while (b < c) {
                val sum = nums[a] + nums[b] + nums[c]
                if (sum == 0) {
                    result.add(listOf(nums[a], nums[b], nums[c]))
                    b++
                    // Any other b that satisfies the sum must have a different c.
                    // We move both pointers to find the next unique pair.
                    c--

                    while (b < c && nums[b] == nums[b - 1]) b++
                    while (b < c && nums[c] == nums[c + 1]) c--
                } else if (sum > 0) {
                    c--
                } else {
                    b++
                }
            }
        }

        return result
    }
}
