class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()

        val combinations = mutableListOf<List<Int>>()
        fun bt(l: MutableList<Int>, lo: Int, sum: Int) {
            if (l in combinations) {
                return
            }

            if (sum == target) {
                combinations.add(l.toList())
            } else if (sum > target) {
                return
            } else {
                for (i in lo..candidates.lastIndex) {
                    l.add(candidates[i])
                    bt(l, i, sum + candidates[i])
                    l.removeLast()
                }
            }
        }

        bt(mutableListOf(), 0, 0)

        return combinations
    }
}