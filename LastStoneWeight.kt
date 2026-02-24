import java.util.PriorityQueue

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int> { a, b -> b - a }.apply { addAll(stones.toList()) }

        while (pq.size >= 2) {
            val s1 = pq.remove()
            val s2 = pq.remove()

            if (s1 > s2) {
                pq.add(s1 - s2)
            } else if (s1 < s2) {
                pq.add(s2 - s1)
            }
        }

        return pq.firstOrNull() ?: 0
    }
}
