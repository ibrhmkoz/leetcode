import java.util.PriorityQueue

class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = tasks.asList().groupingBy { it }.eachCount().values

        val maxPq = PriorityQueue(Comparator.reverseOrder<Int>()).apply {
            addAll(freq)
        }

        val frozen = ArrayDeque<Pair<Int, Int>>()

        var t = 0
        while (maxPq.isNotEmpty() || frozen.isNotEmpty()) {
            maxPq.poll()?.let {
                if (it > 1) {
                    frozen.add(it - 1 to t + n)
                }
            }

            frozen.firstOrNull()?.let {
                if (it.second == t) {
                    frozen.removeFirst()
                    maxPq.add(it.first)
                }
            }

            t++
        }

        return t
    }
}
