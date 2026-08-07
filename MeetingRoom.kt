class Solution {
    fun canAttendMeetings(intervals: List<Interval>) =
        intervals.sortedBy { it.start }.zipWithNext().all { (a, b) -> a.end <= b.start }
}
