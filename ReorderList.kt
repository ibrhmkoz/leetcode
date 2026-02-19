class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode?.middle(): ListNode? {
    var slow = this
    var fast = this?.next

    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}

fun ListNode?.reverse() {
    var cur = this
    var prev: ListNode? = null
    while (cur != null) {
        val next = cur.next
        cur.next = prev
        prev = cur
        cur = next
    }
}

fun ListNode?.tail(): ListNode? {
    var cur: ListNode = this ?: return null
    while (cur.next != null) {
        cur = cur.next!!
    }

    return cur
}

class Solution {
    fun reorderList(head: ListNode?): Unit {
        val mid = head.middle()
        var lo = head
        var hi = head.tail()
        mid.reverse()
        while (lo != mid) {
            val loNext = lo?.next
            val hiNext = hi?.next

            lo?.next = hi
            hi?.next = loNext

            lo = loNext
            hi = hiNext
        }
        lo?.next = null
    }
}
