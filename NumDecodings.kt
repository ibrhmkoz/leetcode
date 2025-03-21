class Solution {
    fun numDecodings(s: String): Int {
        val cache = mutableMapOf<Int, Int>()
        fun read(i: Int): Int {
            if (i == s.length) return 1
            if (s[i] == '0') return 0

            cache[i]?.let { return it }

            val result =
                read(i + 1) + if (i + 1 <= s.lastIndex && s.substring(i..i + 1).toInt() <= 26) read(i + 2) else 0
            cache[i] = result
            return result
        }

        return read(0)
    }
}