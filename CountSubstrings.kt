class Solution {
    fun countSubstrings(s: String): Int {
        var count = 0
        fun expand(l: Int, r: Int) {
            var i = l
            var j = r
            while (i >= 0 && j <= s.lastIndex) {
                if (s[i] == s[j]) {
                    count++
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

        return count
    }
}