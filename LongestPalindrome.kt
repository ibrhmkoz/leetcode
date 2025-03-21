class Solution {
    fun longestPalindrome(s: String): String {
        var maxLength = 0
        var start = 0
        var end = 0
        fun expand(l: Int, r: Int) {
            var i = l
            var j = r

            while (i >= 0 && j <= s.lastIndex) {
                if (s[i] == s[j]) {
                    val length = j - i + 1
                    if (length > maxLength) {
                        maxLength = length
                        start = i
                        end = j
                    }
                } else {
                    break
                }
                i--
                j++
            }
        }

        for (i in s.indices) {
            expand(i, i)
            expand(i, i + 1)
        }

        return s.substring(start..end)
    }
}