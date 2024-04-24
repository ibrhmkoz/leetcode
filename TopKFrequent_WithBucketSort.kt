class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val m = nums.toList().groupingBy { it }.eachCount()

        val bk = List<MutableList<Int>>(nums.size + 1) { mutableListOf() }

        m.forEach {
            bk[it.value].add(it.key)
        }

        val tk = IntArray(k) { 0 }
        var i = 0
        for (b in bk.asReversed()) {
            for (e in b) {
                tk[i] = e
                i++
                if (i == k) {
                    return tk
                }
            }
        }

        return tk
    }
}
