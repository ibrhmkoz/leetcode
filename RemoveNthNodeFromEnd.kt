/**
 * Remove Nth Node From End of List
 * 
 * Add a dummy node to eliminate the edge case of removing the head. The dummy
 * doesn't affect indices from the right (which we care about), only from the left.
 * Convert nth-from-end to nth-from-left, then traverse to the node right before
 * the target (i - 2 steps) to perform the removal.
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun ListNode?.size(): Int {
    var s = 0
    var cur = this
    while (cur != null) {
        s++
        cur = cur.next
    }
    return s
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply {
            next = head
        }

        val size = dummy.size()
        val i = size + 1 - n

        var cur: ListNode? = dummy
        repeat(i - 2) {
            cur = cur!!.next
        }

        cur!!.next = cur.next?.next
        return dummy.next
    }
}
```
