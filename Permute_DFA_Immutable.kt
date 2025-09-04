class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val choices = nums.toSet()
        val permutations = mutableListOf<List<Int>>()

        fun _permute(permutation: List<Int>, currentChoices: Set<Int>) {
            // The following condition implies a final state in the state machine.
            if (currentChoices.isEmpty()) {
                permutations.add(permutation.toList())
                return
            }


            for (choice in currentChoices) {
                _permute(permutation + choice, currentChoices - choice)
            }
        }

        _permute(emptyList(), choices)

        return permutations
    }
}
