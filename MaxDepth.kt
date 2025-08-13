class Solution {
    fun maxDepth(root: TreeNode?): Int {
        fun md(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }

            return 1 + maxOf(
                md(node.left),
                md(node.right),
            )
        }

        return md(root)
    }
}
