class Solution {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        val parentheses = mapOf(
            '}' to '{',
            ']' to '[',
            ')' to '('
        )

        for (c in s) {
            val opening = parentheses[c]
            if (opening != null) {
                val last = stack.removeLastOrNull()
                if (last != opening) {
                    return false
                }
            } else {
                stack.add(c)
            }
        }

        return stack.isEmpty()
    }
}
