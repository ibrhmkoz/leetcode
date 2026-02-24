import java.util.PriorityQueue

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>()

        for (n in nums) {
            pq.add(n)
            if (pq.size > k) {
                pq.remove()
            }
        }

        return pq.peek()
    }
}
