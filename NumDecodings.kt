class Solution {
    fun numDecodings(s: String): Int {
        val cache = mutableMapOf<Int, Int>()
        fun count(i: Int): Int = when {
            i > s.lastIndex -> 1
            s[i] == '0' -> 0
            else -> cache.getOrPut(i) {
                count(i + 1) + if (i < s.lastIndex && s.substring(i, i + 2).toInt() <= 26) count(i + 2) else 0
            }
        }
        return count(0)
    }
}
