class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val paths = mutableListOf<List<Int>>(listOf())

        val path = mutableListOf<Int>()
        fun visit(u: Int) {
            path.add(nums[u])
            paths.add(path.toList())
            for (v in u + 1..nums.lastIndex) {
                visit(v)
            }
            path.removeLast()

        }

        for (u in nums.indices) {
            visit(u)
        }

        return paths
    }
}
