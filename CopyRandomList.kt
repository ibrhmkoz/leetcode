class Solution {
    fun copyRandomList(head: Node?): Node? {
        val cache = mutableMapOf<Node, Node>()

        fun copy(cur: Node?): Node? {
            cur ?: return null
            cache[cur]?.let {
                return it
            }
            val cp = Node(cur.`val`)
            cache[cur] = cp

            cp.next = copy(cur.next)
            cp.random = copy(cur.random)
            return cp
        }

        return copy(head)
    }
}
