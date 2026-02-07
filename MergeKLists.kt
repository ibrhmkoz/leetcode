class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val nodes = ArrayDeque(lists.filterNotNull())

        fun merge(l1: ListNode, l2: ListNode): ListNode {
            var p1: ListNode? = l1
            var p2: ListNode? = l2

            val dummy = ListNode(0)
            var cur = dummy
            while (p1 != null && p2 != null) {
                if (p1.`val` < p2.`val`) {
                    cur.next = ListNode(p1.`val`)
                    p1 = p1.next
                } else {
                    cur.next = ListNode(p2.`val`)
                    p2 = p2.next
                }
                cur = cur.next!!
            }

            cur.next = p1 ?: p2
            return dummy.next!!
        }

        while (nodes.size > 1) {
            nodes.add(merge(nodes.removeFirst(), nodes.removeFirst()))
        }
        return nodes.firstOrNull()
    }
}
