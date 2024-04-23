class AnagramGrouper {
    private var angs = mutableMapOf<String, MutableList<String>>()

    fun add(s: String) {
        val ang = anagramOf(s)
        val l = angs.getOrDefault(ang, mutableListOf())
        l.add(s)
        angs[ang] = l
    }

    private fun anagramOf(s: String) = s.toCharArray().sorted().joinToString("")

    fun groups(): List<List<String>> {
        return angs.values.toList()
    }
}


class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ag = AnagramGrouper()
        for (s in strs) {
            ag.add(s)
        }

        return ag.groups()
    }
}
