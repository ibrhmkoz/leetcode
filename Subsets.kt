class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>(listOf())

        for (num in nums) {
            for (s in result.toList()) {
                result.add(s + num)
            }
        }

        return result
    }
}
