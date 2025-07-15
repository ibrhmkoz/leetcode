class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = nums.toList().groupingBy { it }.eachCount()

        val bucket = List(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in freqMap.entries) {
            bucket[freq].add(num)
        }

        val topKs = mutableListOf<Int>()

        for (freqGroup in bucket.reversed()) {
            if (topKs.size < k) {
                topKs.addAll(freqGroup)
            }
        }

        return topKs.toIntArray()
    }
}
