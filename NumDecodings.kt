class Solution {
    fun numDecodings(s: String): Int {
        val cache = mutableMapOf<Int, Int>()
        fun count(i: Int): Int {
            if (i > s.lastIndex) return 1
            if (s[i] == '0') return 0
            return cache.getOrPut(i) {
                count(i + 1) + if (i < s.lastIndex && s.substring(i, i + 2).toInt() <= 26) count(i + 2) else 0
            }
        }
        return count(0)
    }
}
