class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        root ?: return true

        fun isValid(node: TreeNode?, min: Long, max: Long): Boolean {
            node ?: return true

            return node.`val` in (min + 1)..<max &&
                    isValid(node.left, min, node.`val`.toLong()) &&
                    isValid(node.right, node.`val`.toLong(), max)
        }

        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}
