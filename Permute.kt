class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val choices = nums.toMutableSet()
        val permutation = mutableListOf<Int>()
        val permutations = mutableListOf<List<Int>>()

        fun _permute() {
            if (permutation.size == nums.size) {
                permutations.add(permutation.toList())
            }

            for (choice in choices.toList()) {
                permutation.add(choice)
                choices.remove(choice)
                _permute()
                permutation.removeLast()
                choices.add(choice)
            }
        }

        _permute()
        return permutations
    }
}
