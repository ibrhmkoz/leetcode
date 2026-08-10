class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        val seq = mutableListOf<Char>()
        fun gen(open: Int, closed: Int) {
            if (open == n && closed == n) {
                res.add(seq.joinToString(""))
            }

            if (open < n) {
                seq.add('(')
                gen(open + 1, closed)
                seq.removeLast()
            }

            if (closed < open) {
                seq.add(')')
                gen(open, closed + 1)
                seq.removeLast()
            }
        }

        gen(0, 0)
        return res
    }
}
