/**
 * Remove Nth Node From End of List (One Pass)
 * 
 * Use two pointers with a gap of n+1 nodes between them. When the lead pointer
 * reaches the end, the trailing pointer will be at the node right before the
 * target node, allowing us to perform the removal in a single traversal.
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0).apply {
            next = head
        }

        var lead: ListNode? = dummy
        repeat(n + 1) {
            lead = lead?.next
        }

        var trailing: ListNode? = dummy
        while (lead != null) {
            trailing = trailing?.next
            lead = lead.next
        }

        trailing!!.next = trailing.next?.next
        return dummy.next
    }
}
