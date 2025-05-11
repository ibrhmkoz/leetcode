class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()

        intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

        val newIntervals = mutableListOf(
            intervals.first()
        )

        fun merge(i1: IntArray, i2: IntArray): IntArray? {
            if (i2[0] <= i1[1]) {
                return intArrayOf(i1[0], maxOf(i1[1], i2[1]))
            }
            return null
        }

        for (interval in intervals.slice(1..intervals.lastIndex)) {
            val lastEl = newIntervals.removeLast()

            val merged = merge(lastEl, interval)
            if (merged != null) {
                newIntervals.add(merged)
            } else {
                newIntervals.add(lastEl)
                newIntervals.add(interval)
            }
        }

        return newIntervals.toTypedArray()
    }
}
