class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var lo = 1
        var hi = piles.max()
        while (lo < hi) {
            val mid = (lo + hi) / 2
            val total = piles.sumOf { (it + mid - 1) / mid }
            if (total > h) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        return lo
    }
}
