class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val adj = mutableMapOf<Char, MutableSet<Char>>()

        for (w in words) {
            for (c in w) {
                adj.putIfAbsent(c, mutableSetOf())
            }
        }

        for ((w1, w2) in words.asList().windowed(2)) {
            for ((c1, c2) in w1.zip(w2)) {
                if (c1 != c2) {
                    adj.getOrPut(c1) { mutableSetOf() }.add(c2)
                    break
                }
            }
        }

        val visited = mutableSetOf<Char>()
        val path = mutableSetOf<Char>()
        val res = mutableListOf<Char>()

        fun dfs(char: Char): Boolean {
            if (char in path) {
                return true
            }

            if (char in visited) {
                return false
            }

            visited.add(char)
            path.add(char)

            if ((adj[char] ?: emptySet()).any { dfs(it) }) {
                return true
            }

            path.remove(char)
            res.add(char)
            return false
        }

        for (char in adj.keys) {
            if (dfs(char)) {
                return ""
            }
        }

        return res.reversed().joinToString("")
    }
}
