class Solution {
    fun reorderList(head: ListNode?): Unit {
        var s = head
        var f = head

        while (f?.next != null) {
            s = s?.next
            f = f.next?.next
        }

        var c = s?.next
        s?.next = null

        var p: ListNode? = null
        while (c != null) {
            val t = c.next
            c.next = p
            p = c
            c = t
        }

        var a = head
        var b = p

        while (b != null) {
            val t1 = a?.next
            val t2 = b.next
            a?.next = b
            b.next = t1
            a = t1
            b = t2
        }
    }
}
