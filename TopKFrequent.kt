typealias Freq = Int

class Counter {
    private val freq = mutableMapOf<Int, Freq>()

    fun add(num: Int) {
        freq[num] = freq.getOrDefault(num, 0) + 1
    }

    fun top(k: Int): IntArray {
        return freq.toList().sortedByDescending { it.second }.take(k).map { it.first }.toIntArray()
    }
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val c = Counter()
        nums.forEach { c.add(it) }
        return c.top(k)
    }
}
