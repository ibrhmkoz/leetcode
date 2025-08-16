class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class LevelOrderTreeIter(root: TreeNode?) : Iterator<TreeNode> {
    private val unvisiteds = ArrayDeque<TreeNode>().apply {
        root?.let { add(it) }
    }

    override fun hasNext() = unvisiteds.isNotEmpty()

    override fun next(): TreeNode {
        val node = unvisiteds.removeFirst()
        node.left?.let { unvisiteds.add(it) }
        node.right?.let { unvisiteds.add(it) }
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

        return LevelOrderTreeIter(root).asSequence().any { isSame(it, subRoot) }
    }
}
