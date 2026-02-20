import java.util.PriorityQueue

class MedianFinder() {
    private val small = PriorityQueue<Int> { a, b -> b - a }
    private val large = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (large.isNotEmpty() && num > large.peek()) {
            large.add(num)
        } else {
            small.add(num)
        }
        if (large.size - small.size > 1) {
            small.add(large.remove())
        } else if (small.size - large.size > 1) {
            large.add(small.remove())
        }
    }

    fun findMedian(): Double {
        return if (large.size > small.size) {
            large.peek().toDouble()
        } else if (large.size < small.size) {
            small.peek().toDouble()
        } else {
            (small.peek() + large.peek()).toDouble() / 2
        }
    }
}
