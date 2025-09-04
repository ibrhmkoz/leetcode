class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val subsets = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        fun bt(i: Int) {
            subsets.add(current.toList())
            for (j in i until nums.size) {
                if (j > i && nums[j] == nums[j - 1]) {
                    continue
                }
                current.add(nums[j])
                bt(j + 1)
                current.removeLast()
            }
        }

        bt(0)
        return subsets
    }
}
