import java.util.PriorityQueue

fun movingMedian(arr: IntArray): String {
    if (arr.isEmpty()) return ""

    val w = arr[0]
    val data = arr.drop(1)

    val left = PriorityQueue<Int>(compareByDescending { it })
    val right = PriorityQueue<Int>()
    val delCnt = mutableMapOf<Int, Int>()
    var lSize = 0
    var rSize = 0
    val res = StringBuilder()

    fun prune() {
        while (left.isNotEmpty() && (delCnt[left.peek()] ?: 0) > 0) {
            val t = left.poll()
            delCnt[t] = delCnt[t]!! - 1
        }
        while (right.isNotEmpty() && (delCnt[right.peek()] ?: 0) > 0) {
            val t = right.poll()
            delCnt[t] = delCnt[t]!! - 1
        }
    }

    for ((i, v) in data.withIndex()) {
        left.add(v)
        right.add(left.poll())
        rSize++

        if (i >= w) {
            val old = data[i - w]
            delCnt[old] = (delCnt[old] ?: 0) + 1
            if (old <= left.peek()) lSize-- else rSize--
            prune()
        }

        if (rSize > lSize) {
            left.add(right.poll())
            rSize--; lSize++
            prune()
        }

        val med: Double =
            if (lSize != rSize) left.peek().toDouble()
            else (left.peek().toLong() + right.peek().toLong()) / 2.0

        if (res.isNotEmpty()) res.append(',')
        res.append(if (med == med.toLong().toDouble()) med.toLong().toString() else med.toString())
    }

    return res.toString()
}

fun main() {
    println(movingMedian(intArrayOf(3, 1, 3, 5, 10, 6, 4, 3, 1)))   // 1,2,3,5,6,6,4
    println(movingMedian(intArrayOf(3, 1, 3, -1, -3, 5, 3, 6, 7)))  // 1,2,1,-1,-1,3,5,6
    println(movingMedian(intArrayOf(2, 4, 6)))                      // 4,5
    println(movingMedian(intArrayOf(1, 9, 2, 5)))                   // 9,2,5
    println(movingMedian(intArrayOf(5, 3, 3, 3)))                   // 3,3,3
    println(movingMedian(intArrayOf(3)))                            // ""
}
