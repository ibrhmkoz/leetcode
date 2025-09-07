fun isPalindrome(s: String): Boolean {
    var lo = 0
    var hi = s.lastIndex

    while (lo <= hi) {
        if (s[lo] != s[hi]) {
            return false
        }
        lo++
        hi--
    }

    return true
}

class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()

        val current = mutableListOf<String>()
        fun bt(i: Int) {
            if (i == s.length) {
                result.add(current.toList())
            }
            for (j in i..s.lastIndex) {
                val substring = s.substring(i..j)
                if (isPalindrome(substring)) {
                    current.add(substring)
                    bt(j + 1)
                    current.removeLast()
                }
            }
        }

        bt(0)
        return result
    }
}
