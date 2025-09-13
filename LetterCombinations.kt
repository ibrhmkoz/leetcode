class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val chars = mutableMapOf(
            '2' to listOf('a', 'b', 'c'),
            '3' to listOf('d', 'e', 'f'),
            '4' to listOf('g', 'h', 'i'),
            '5' to listOf('j', 'k', 'l'),
            '6' to listOf('m', 'n', 'o'),
            '7' to listOf('p', 'q', 'r', 's'),
            '8' to listOf('t', 'u', 'v'),
            '9' to listOf('w', 'x', 'y', 'z'),
        )

        val result = mutableListOf<String>()
        val cur = mutableListOf<Char>()
        fun bt(i: Int) {
            if (i == digits.length) {
                result.add(cur.joinToString(""))
                return
            }
            for (ch in chars[digits[i]]!!) {
                cur.add(ch)
                bt(i + 1)
                cur.removeLast()
            }
        }
        
        bt(0)
        return result
    }
}
