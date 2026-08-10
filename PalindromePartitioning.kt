class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val seq = mutableListOf<String>()
        fun pal(start: Int) {
            if (start == s.length) {
                res.add(seq.toList())
            }

            for (end in start..s.lastIndex) {
                val sub = s.substring(start..end)
                if (sub.isPalindrome()) {
                    seq.add(sub)
                    pal(end + 1)
                    seq.removeLast()
                }
            }
        }

        pal(0)

        return res
    }
}

fun String.isPalindrome() = (0..<length / 2).all { this[it] == this[this.lastIndex - it] }
