class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val queue = PriorityQueue<Int>(compareByDescending { it }).apply {
            addAll(tasks.asList().groupingBy { it }.eachCount().values)
        }
        val frozen = ArrayDeque<Pair<Int, Int>>()

        var t = 0
        while (queue.isNotEmpty() || frozen.isNotEmpty()) {
            t++

            // Time-jump: if queue is empty, jump to next unfreeze time
            if (queue.isEmpty() && frozen.isNotEmpty()) {
                t = frozen.first().second
            }

            frozen.firstOrNull()?.let {
                val (freq, rescheduleTime) = it
                if (rescheduleTime == t) {
                    frozen.removeFirst()
                    queue.add(freq)
                }
            }
            queue.poll()?.let {
                if (it > 1) {
                    frozen.add(it - 1 to t + n + 1)
                }
            }
        }

        return t
    }
}
