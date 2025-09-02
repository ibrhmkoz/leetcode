class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>(listOf())

        for (num in nums) {
            for (subset in result.toList()) {
                result.add(subset + num)
            }
        }

        return result
    }
}
