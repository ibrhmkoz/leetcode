class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        var max = Int.MIN_VALUE
        fun maxSum(node: TreeNode?): Int {
            if (node == null) {
                return 0
            }

            val left = maxOf(0, maxSum(node.left))
            val right = maxOf(0, maxSum(node.right))

            max = maxOf(node.`val` + left + right, max)
            return node.`val` + maxOf(left, right)
        }

        maxSum(root)
        return max
    }
}
