class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        fun lca(node: TreeNode?): TreeNode? {
            node ?: return null

            return if (node.`val` in listOf(p?.`val`, q?.`val`)) {
                node
            } else {
                listOf(lca(node.left), lca(node.right)).run {
                    when {
                        none { it == null } -> node
                        else -> firstOrNull { it != null }
                    }
                }
            }
        }

        return lca(root)
    }
}
