class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val g = mutableMapOf<Char, MutableList<Char>>()

        for (w in words) {
            for (c in w) {
                g[c] = mutableListOf()
            }
        }

        outer@ for ((w1, w2) in words.asList().windowed(2)) {
            for ((a, b) in w1.zip(w2)) {
                if (a != b) {
                    g[a]!!.add(b)
                    continue@outer
                }
            }

            if (w1.length > w2.length) {
                return ""
            }
        }

        val res = mutableListOf<Char>()

        val visited = mutableMapOf<Char, Int>()
        fun hasCycle(c: Char): Boolean {
            visited[c]?.let {
                if (it == 1) {
                    return true
                } else if (it == 2) {
                    return false
                }
            }

            visited[c] = 1
            for (adj in g[c] ?: emptyList()) {
                if (hasCycle(adj)) {
                    return true
                }
            }
            visited[c] = 2
            res.add(c)
            return false
        }

        for (c in g.keys) {
            if (hasCycle(c)) {
                return ""
            }
        }

        return res.asReversed().joinToString("")
    }
}
