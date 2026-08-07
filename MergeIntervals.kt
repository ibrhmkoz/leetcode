class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        for (iv in intervals) {
            val last = result.lastOrNull()
            if (last != null && last[1] >= iv[0]) {
                last[1] = maxOf(last[1], iv[1])
            } else {
                result.add(iv)
            }
        }
        return result.toTypedArray()
    }
}
