class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val m = IntArray(26) { 0 }

        s.forEach { m[it - 'a'] += 1 }
        t.forEach { m[it - 'a'] -= 1 }

        return m.all { it == 0 }
    }
}
