fun anagramOf(s: String) = s.toCharArray().sorted().joinToString("")

class AnagramGrouper {
    private val angs = mutableMapOf<String, MutableList<String>>()

    fun add(s: String) {
        val ang = anagramOf(s)
        angs.getOrPut(ang, ::mutableListOf).add(s)
    }

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
