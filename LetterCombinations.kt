class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val chars = arrayOf(
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        )

        val result = mutableListOf<String>()
        val cur = mutableListOf<Char>()
        fun bt(i: Int) {
            if (i == digits.length) {
                result.add(cur.joinToString(""))
                return
            }
            val digit = digits[i] - '0' - 2
            for (ch in chars[digit]) {
                cur.add(ch)
                bt(i + 1)
                cur.removeLast()
            }
        }

        bt(0)
        return result
    }
}
