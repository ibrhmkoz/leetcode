class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<ListNode>() { n1, n2 -> n1.`val` - n2.`val` }
        lists.filterNotNull().forEach { queue.add(it) }

        val dummy = ListNode(0)
        var cur = dummy
        while (queue.isNotEmpty()) {
            val node = queue.remove()
            cur.next = ListNode(node.`val`)
            cur = cur.next!!
            node.next?.let { queue.add(it) }
        }

        return dummy.next
    }
}
