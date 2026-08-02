class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()

        val res = mutableListOf<List<Int>>()
        val seq = mutableListOf<Int>()

        fun bt(i: Int, sum: Int) {
            if (sum > target) return
            if (sum == target) {
                res.add(seq.toList())
                return
            }
            if (i == candidates.size) return

            seq.add(candidates[i])
            bt(i + 1, sum + candidates[i])
            seq.removeLast()

            var j = i
            while (j < candidates.lastIndex && candidates[j] == candidates[j + 1]) j++
            bt(j + 1, sum)
        }

        bt(0, 0)
        return res
    }
}
