/**
 * LIS using greedy approach with binary search.
 *
 * Key insight: At any point, if we have two increasing subsequences of the same length,
 * the one ending with the smaller number is always better because it provides more
 * opportunities for future extensions.
 *
 * Why maintain multiple subsequences instead of just the longest?
 * Because future numbers might extend a shorter subsequence to create an even longer
 * sequence than our current longest one.
 *
 * The 'tails' array stores the smallest possible ending element for each subsequence length.
 * tails[i] = smallest tail of all increasing subsequences of length (i+1)
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val tails = mutableListOf<Int>()
        for (n in nums) {
            val insertInd = tails.binarySearch(n).let {
                if (it >= 0) it else -(it + 1)
            }
            if (insertInd == tails.size) {
                tails.add(n)
            } else {
                tails[insertInd] = n
            }
        }

        return tails.size
    }
}
