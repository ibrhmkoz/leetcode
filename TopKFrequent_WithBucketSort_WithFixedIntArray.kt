class FixedIntArray(capacity: Int) {
    private val wrapped = IntArray(capacity)
    private var currentIndex = 0


    /**
     * Adds an element to the next available position in the array.
     * @return `true` if the element was added successfully, `false` if the array is full.
     */
    fun add(element: Int): Boolean {
        if (currentIndex >= wrapped.size) {
            return false
        }
        wrapped[currentIndex] = element
        currentIndex++
        return true
    }

    fun unwrap() = wrapped
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = nums.asList().groupingBy { it }.eachCount()

        val bucket = List(nums.size + 1) { mutableListOf<Int>() }

        for ((num, freq) in freqMap.entries) {
            bucket[freq].add(num)
        }

        val topKs = FixedIntArray(k)

        outerLoop@ for (freqGroup in bucket.reversed()) {
            for (num in freqGroup) {
                if (!topKs.add(num)) {
                    break@outerLoop
                }
            }
        }

        return topKs.unwrap()
    }
}
