class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        val seq = mutableListOf<Int>()
        val end = nums.lastIndex
        fun cs(start: Int) {
            val sum = seq.sum()
            if (sum > target) {
                return
            }

            if (sum == target) {
                res.add(seq.toList())
            }

            for (i in start..end) {
                seq.add(nums[i])
                cs(i)
                seq.removeLast()
            }
        }

        cs(0)
        return res
    }
}
