class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        fun merge(first: IntArray, second: IntArray): IntArray =
            intArrayOf(minOf(first[0], second[0]), maxOf(first[1], second[1]))


        val newIntervals = mutableListOf<IntArray>()

        var i = 0
        while (i <= intervals.lastIndex && intervals[i][1] < newInterval[0]) {
            newIntervals.add(intervals[i])
            i++
        }

        var merged = newInterval
        while (i <= intervals.lastIndex && intervals[i][0] <= merged[1]) {
            merged = merge(merged, intervals[i])
            i++
        }

        newIntervals.add(merged)

        while (i <= intervals.lastIndex) {
            newIntervals.add(intervals[i])
            i++
        }

        return newIntervals.toTypedArray()
    }
}
