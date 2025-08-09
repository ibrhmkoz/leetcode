class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()
        fun lcs(i: Int, j: Int): Int =
            if (i == text1.length || j == text2.length) {
                0
            } else {
                cache.getOrPut(i to j) {
                    if (text1[i] == text2[j]) {
                        1 + lcs(i + 1, j + 1)
                    } else {
                        maxOf(lcs(i + 1, j), lcs(i, j + 1))
                    }
                }
            }

        return lcs(0, 0)
    }
}
