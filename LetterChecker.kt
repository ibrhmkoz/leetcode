import kotlin.math.max

class LetterChecker(private val k: Int) {
    private val letters = mutableMapOf<Char, Int>()

    fun addChar(char: Char) {
        letters[char] = letters.getOrDefault(char, 0) + 1
    }

    fun isOk(): Boolean {
        if (letters.isEmpty()) return true

        val maxFreq = letters.values.maxOrNull() ?: 0
        val totalChars = letters.values.sum()

        return totalChars - maxFreq <= k
    }

    fun removeChar(char: Char) {
        val count = letters[char] ?: 0
        if (count <= 1) {
            letters.remove(char)
        } else {
            letters[char] = count - 1
        }
    }
}

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val letterChecker = LetterChecker(k)
        var lo = 0
        var max = Int.MIN_VALUE
        for (hi in s.indices) {
            letterChecker.addChar(s[hi])
            while (!letterChecker.isOk()) {
                letterChecker.removeChar(s[lo])
                lo++
            }

            max = max(max, hi - lo + 1)
        }

        return max
    }
}