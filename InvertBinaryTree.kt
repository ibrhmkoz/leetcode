class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        fun invert(node: TreeNode?) {
            if (node == null) {
                return
            }

            val left = node.left
            node.left = node.right
            node.right = left

            invert(node.left)
            invert(node.right)
        }

        invert(root)

        return root
    }
}
