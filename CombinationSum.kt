class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val combs = mutableListOf<List<Int>>()
        fun search(seq: List<Int>, p: Int, sum: Int) {
            when {
                sum > target || p == candidates.size -> Unit
                sum == target -> combs.add(seq)
                else -> {
                    search(seq + candidates[p], p, sum + candidates[p])
                    search(seq, p + 1, sum)
                }
            }
        }

        search(emptyList(), 0, 0)
        return combs
    }
}
