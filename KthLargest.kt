import java.util.PriorityQueue

class KthLargest(private val k: Int, nums: IntArray) {
    private val scores = PriorityQueue<Int>(k)

    init {
        for (n in nums) {
            add(n)
        }
    }

    fun add(`val`: Int): Int {
        scores.add(`val`)
        if (scores.size > k) {
            scores.remove()
        }
        return scores.peek()
    }
}
