class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = mutableMapOf<Int, Boolean>()
        fun wb(i: Int): Boolean =
            i == s.length || cache.getOrPut(i) {
                wordDict.any { s.startsWith(it, i) && wb(i + it.length) }
            }

        return wb(0)
    }
}
