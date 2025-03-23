class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = mutableMapOf<Int, Boolean>()
        fun cmp(i: Int): Boolean {
            if (i == s.length) return true
            cache[i]?.let { return it }

            val result =
                wordDict.any { i + it.length <= s.length && s.substring(i until i + it.length) == it && cmp(i + it.length) }
            cache[i] = result
            return result
        }

        return cmp(0)
    }
}