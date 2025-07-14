class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeen = mutableMapOf<Char, Int>()
        var lo = 0
        var longest = 0

        for ((hi, ch) in s.withIndex()) {
            lastSeen[ch]?.let {
                if (it >= lo) {
                    lo = it + 1
                }
            }

            lastSeen[ch] = hi
            longest = maxOf(longest, hi - lo + 1)
        }

        return longest
    }
}
