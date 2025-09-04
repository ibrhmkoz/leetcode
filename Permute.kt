class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val choices = nums.toSet()
        val permutation = mutableListOf<Int>()
        val permutations = mutableListOf<List<Int>>()

        fun _permute(currentChoices: Set<Int>) {
            if (permutation.size == choices.size) {
                permutations.add(permutation.toList())
            }
            for (choice in currentChoices) {
                permutation.add(choice)
                _permute(currentChoices - choice)
                permutation.removeLast()
            }
        }

        _permute(choices)

        return permutations
    }
}
