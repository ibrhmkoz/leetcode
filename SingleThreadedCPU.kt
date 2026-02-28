data class Task(val index: Int, val enqueueTime: Int, val processingTime: Int)

class Solution {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val pending = ArrayDeque<Task>()
        tasks.mapIndexed { index, task -> Task(index, task.first(), task.last()) }
            .sortedWith(compareBy<Task>({ it.enqueueTime }).thenBy { it.index })
            .toCollection(pending)

        val available = PriorityQueue<Task>(compareBy({ it.processingTime }, { it.index }))

        val order = mutableListOf<Int>()
        var time = pending.first().enqueueTime
        while (pending.isNotEmpty() || available.isNotEmpty()) {
            while (pending.isNotEmpty()) {
                val next = pending.first()
                if (next.enqueueTime <= time) {
                    pending.removeFirst()
                    available.add(next)
                } else {
                    break
                }
            }

            val next = available.poll()
            if (next != null) {
                time += next.processingTime
                order.add(next.index)
            } else {
                time = pending.first().enqueueTime
            }
        }

        return order.toIntArray()
    }
}
