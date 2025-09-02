class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()

        val paths = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun visit(u: Int) {
            path.add(candidates[u])
            val sum = path.sum()

            if (sum == target) {
                paths.add(path.toList())
            } else if (sum < target) {
                for (v in u + 1..candidates.lastIndex) {
                    if (v > u + 1 && candidates[v] == candidates[v - 1]) {
                        continue
                    }
                    visit(v)
                }
            }

            path.removeLast()
        }

        for (u in candidates.indices) {
            if (u > 0 && candidates[u - 1] == candidates[u]) {
                continue
            }

            visit(u)
        }

        return paths
    }
}
