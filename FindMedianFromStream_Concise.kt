class MedianFinder() {
    private val small = PriorityQueue<Int> { a, b -> b - a }
    private val large = PriorityQueue<Int>()

    fun addNum(num: Int) {
        small.add(num)
        large.add(small.remove())
        if (large.size - small.size > 1) {
            small.add(large.remove())
        }
    }

    fun findMedian(): Double {
        return if (large.size > small.size) {
            large.peek().toDouble()
        } else {
            (small.peek() + large.peek()).toDouble() / 2
        }
    }
}
