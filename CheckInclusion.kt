class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) {
            return false
        }

        val freq1 = IntArray(26)
        val freq2 = IntArray(26)
        for (i in s1.indices) {
            freq1[s1[i] - 'a']++
            freq2[s2[i] - 'a']++
        }

        if (freq1.contentEquals(freq2)) {
            return true
        }

        for (i in s1.length..<s2.length) {
            freq2[s2[i - s1.length] - 'a']--
            freq2[s2[i] - 'a']++
            if (freq1.contentEquals(freq2)) {
                return true
            }
        }

        return false
    }
}
