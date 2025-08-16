class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class InorderTreeIter(root: TreeNode?) : Iterator<TreeNode> {
    private val stack = mutableListOf<TreeNode>()

    init {
        pushLeftPath(root)
    }

    private fun pushLeftPath(node: TreeNode?) {
        var cur = node
        while (cur != null) {
            stack.add(cur)
            cur = cur.left
        }
    }

    override fun next(): TreeNode {
        val node = stack.removeLast()
        pushLeftPath(node.right)
        return node
    }

    override fun hasNext() = stack.isNotEmpty()
}

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int =
        InorderTreeIter(root).asSequence().take(k).last().`val`
}
