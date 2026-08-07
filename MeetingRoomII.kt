class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        if (intervals.isEmpty()) {
            return 0
        }
        val sorted = intervals.sortedBy { it.start }
        val roomEnds = PriorityQueue<Int>()
        for (inv in sorted) {
            roomEnds.peek()?.let {
                if (it <= inv.start) {
                    roomEnds.poll()
                }
            }
            roomEnds.add(inv.end)
        }
        return roomEnds.size
    }
}
