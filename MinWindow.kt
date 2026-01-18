fun cti(c: Char) = if (c in 'A'..'Z') c - 'A' else c - 'a' + 26

class Solution {
    fun minWindow(s: String, t: String): String {
        val target = IntArray(52).apply {
            for (c in t) this[cti(c)]++
        }
        val window = IntArray(52)
        var lo = 0
        var minLen = Int.MAX_VALUE
        var minStart = 0

        for (hi in s.indices) {
            window[cti(s[hi])]++

            while ((0..51).all { window[it] >= target[it] }) {
                if (minLen > hi - lo + 1) {
                    minLen = hi - lo + 1
                    minStart = lo
                }
                window[cti(s[lo])]--
                lo++
            }
        }
        return if (minLen == Int.MAX_VALUE) "" else s.slice(minStart..<minStart + minLen)
    }
}
