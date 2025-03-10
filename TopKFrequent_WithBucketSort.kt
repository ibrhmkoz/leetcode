class FixedIntArray(private val size: Int) {
    private var ind = 0
    private val intArray = IntArray(size)

    fun add(v: Int): Boolean {
        intArray[ind++] = v
        return ind == size
    }

    fun unwrap() = intArray
}


class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val buckets = MutableList<MutableList<Int>>(nums.size + 1) { mutableListOf() }

        nums.toList().groupingBy { it }.eachCount().forEach {
            buckets[it.value].add(it.key)
        }

        val topK = FixedIntArray(k)

        outerLoop@ for (b in buckets.reversed()) {
            for (num in b) {
                if (topK.add(num)) {
                    break@outerLoop
                }
            }
        }

        return topK.unwrap()
    }
}