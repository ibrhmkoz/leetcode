class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var c = 0
        var result: Int? = null
        fun inorder(node: TreeNode?) {
            if (node == null) {
                return
            }

            inorder(node.left)
            c++
            if (c == k) {
                result = node.`val`
                return
            }
            inorder(node.right)
        }

        inorder(root)
        return result!!
    }
}
