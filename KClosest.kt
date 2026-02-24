import java.util.PriorityQueue

fun distance(point: IntArray): Int {
    val (x, y) = point
    return x * x + y * y
}

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val pq = PriorityQueue<IntArray> { a, b -> distance(b) - distance(a) }

        for (p in points) {
            pq.add(p)
            if (pq.size > k) {
                pq.remove()
            }
        }

        return pq.toList().toTypedArray()
    }
}
