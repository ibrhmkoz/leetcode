class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()
        fun lcs(i1: Int, i2: Int): Int {
            if (i1 > text1.lastIndex || i2 > text2.lastIndex) return 0

            cache[i1 to i2]?.let { return it }

            val res = if (text1[i1] == text2[i2]) {
                1 + lcs(i1 + 1, i2 + 1)
            } else {
                maxOf(lcs(i1 + 1, i2), lcs(i1, i2 + 1))
            }

            cache[i1 to i2] = res
            return res
        }

        return lcs(0, 0)
    }
}
