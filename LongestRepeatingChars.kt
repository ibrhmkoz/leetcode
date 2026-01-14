class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val freq = IntArray(26)

        var max = 0
        var lo = 0
        for (hi in s.indices) {
            freq[s[hi] - 'A']++

            val n = freq.sum() - freq.max()
            if (k < n) {
                freq[s[lo] - 'A']--
                lo++
            }

            val l = hi - lo + 1
            max = maxOf(l, max)
        }

        return max
    }
}
