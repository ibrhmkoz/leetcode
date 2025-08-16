class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TreeIter(root: TreeNode?) : Iterator<TreeNode> {
    private val unvisitedNodes = mutableListOf<TreeNode>().apply {
        root?.let { add(it) }
    }

    override fun hasNext() = unvisitedNodes.isNotEmpty()

    override fun next(): TreeNode {
        val node = unvisitedNodes.removeFirst()
        node.left?.let { unvisitedNodes.add(it) }
        node.right?.let { unvisitedNodes.add(it) }
        return node
    }
}

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        fun isSame(n1: TreeNode?, n2: TreeNode?): Boolean =
            if (n1 == null && n2 == null) {
                true
            } else {
                n1?.`val` == n2?.`val`
                        && isSame(n1?.left, n2?.left)
                        && isSame(n1?.right, n2?.right)
            }

        return TreeIter(root).asSequence().any { isSame(it, subRoot) }
    }
}
