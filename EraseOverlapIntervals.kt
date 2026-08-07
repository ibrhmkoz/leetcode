class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[0] }
        var prevEnd = intervals.first()[1]
        var removed = 0
        for ((start, end) in intervals.asSequence().drop(1)) {
            if (start < prevEnd) {
                removed++
                prevEnd = minOf(prevEnd, end)
            } else {
                prevEnd = end
            }
        }
        return removed
    }
}
