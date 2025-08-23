class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val cache = mutableMapOf<Int, Node>()

        fun clone(node: Node?): Node? {
            node ?: return null

            cache[node.`val`]?.let {
                return it
            }

            val copy = Node(node.`val`)
            cache[node.`val`] = copy
            copy.neighbors = ArrayList(
                node.neighbors.map {
                    clone(it)
                }
            )

            return copy
        }

        return clone(node)
    }
}
