class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val charFrequency = IntArray(26)
        var lo = 0
        var maxLength = 0
        var maxFrequent = 0
        for ((hi, ch) in s.withIndex()) {
            val hiCharInd = ch - 'A'
            charFrequency[hiCharInd]++
            maxFrequent = maxOf(maxFrequent, charFrequency[hiCharInd])
            val length = hi - lo + 1
            val freq = length - maxFrequent
            if (freq > k) {
                val loCharInd = s[lo] - 'A'
                charFrequency[loCharInd]--
                lo++
            }

            val finalLength = hi - lo + 1
            maxLength = maxOf(maxLength, finalLength)
        }

        return maxLength
    }
}
