class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1)
        }

        val halfLen = (m + n + 1) / 2

        var lo = 0
        var hi = m

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (nums1[mid] < nums2[halfLen - mid - 1]) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }

        val i = lo
        val j = halfLen - i

        val maxLeft = maxOf(
            nums1.getOrElse(i - 1) { Int.MIN_VALUE },
            nums2.getOrElse(j - 1) { Int.MIN_VALUE }
        )

        if ((m + n) % 2 != 0) {
            return maxLeft.toDouble()
        }

        val minRight = minOf(
            nums1.getOrElse(i) { Int.MAX_VALUE },
            nums2.getOrElse(j) { Int.MAX_VALUE }
        )

        return (maxLeft + minRight).toDouble() / 2

    }
}
