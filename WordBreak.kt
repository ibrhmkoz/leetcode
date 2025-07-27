class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val cache = mutableMapOf<Int, Boolean>()
        fun wb(i: Int): Boolean {
            if (i == s.length) {
                return true
            }

            return cache.getOrPut(i) {
                wordDict
                    .filter {
                        it == runCatching { s.substring(i until i + it.length) }.getOrNull()
                    }
                    .any { wb(i + it.length) }
            }
        }

        return wb(0)
    }
}
