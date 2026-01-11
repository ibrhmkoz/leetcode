class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val uniq = nums.toSet()
        val dp = mutableMapOf<Int, Int>()
        fun lc(n: Int): Int {
            if (n !in uniq) {
                return 0
            }

            return dp.getOrPut(n) {
                1 + lc(n + 1)
            }
        }

        return uniq.maxOfOrNull { lc(it) } ?: 0
    }
}
